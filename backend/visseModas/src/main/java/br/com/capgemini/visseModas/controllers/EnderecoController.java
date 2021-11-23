package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.services.EnderecoService;
import br.com.capgemini.visseModas.models.dtos.request_form.EnderecoForm;
import br.com.capgemini.visseModas.models.dtos.response.EnderecoDTO;
import br.com.capgemini.visseModas.models.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> alterar(@PathVariable Long id, @RequestBody @Valid EnderecoDTO form, UriComponentsBuilder uriBuilder ) {

        Endereco endereco = form.dtoToEndereco();
        endereco = service.alterar(id, form);

        URI uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));

//        Optional<Endereco> optional = enderecoRepository.findById(id);
//        if (optional.isPresent()) {
//            Endereco endereco = form.atualizar(id, enderecoRepository);
//            enderecoRepository.save(endereco);
//            return ResponseEntity.ok(new EnderecoDTO(endereco));
//        }
//
//        return ResponseEntity.notFound().build();


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

    @GetMapping("pageable")
    public Page<EnderecoDTO> listarTudoPaginacao(@PageableDefault(sort="descricao", direction = Sort.Direction.ASC, page=0, size = 8) Pageable paginacao) {
        return service.listarTudoDTOPaginacao(paginacao);
    }

}


