package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.services.EnderecoService;
import br.com.capgemini.visseModas.models.dtos.form.EnderecoForm;
import br.com.capgemini.visseModas.models.dtos.dtos.EnderecoDTO;
import br.com.capgemini.visseModas.models.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoDTO> salvar(@RequestBody @Valid EnderecoForm enderecoForm, UriComponentsBuilder uriBuilder) {

        Endereco endereco = enderecoForm.dtoToEndereco();
        service.salvar(endereco);

        URI uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));
    }


    //deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return service.deletar(id);
    }

    //buscar cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> detalhar(@PathVariable Long id) {
        return service.detalhar(id);
    }

    //listar tudo
    @GetMapping
    public List<EnderecoDTO> listarTudo() {
        return service.listarTudoDTO();
    }

}


