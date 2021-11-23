package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.services.ClienteService;
import br.com.capgemini.visseModas.models.dtos.request_form.ClienteForm;
import br.com.capgemini.visseModas.models.dtos.response.ClienteDTO;
import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.services.EnderecoService;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    @Autowired
    private EnderecoService enderecoService;


    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {

        Cliente cliente = form.formToCliente(enderecoService);
        service.salvar(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> detalhar(@PathVariable Long id) {
        return service.detalhar(id);
    }

    @GetMapping
    public List<ClienteDTO> listarTudo() {
        return service.listarTudoDTO();
    }

    //se não obrigatorio
    @GetMapping("pageable")                     //setando uma ordenacao default, se não passar parametros
    public Page<ClienteDTO> listarTudoPaginacao(@PageableDefault(sort="nome", direction = Sort.Direction.ASC, page=0, size = 10) Pageable paginacao) {
        return service.listarTudoDTOPaginacao(paginacao);
    }








}


