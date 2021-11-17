package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.models.dtos.update.ClienteUpdate;
import br.com.capgemini.visseModas.services.ClienteService;
import br.com.capgemini.visseModas.models.dtos.form.ClienteForm;
import br.com.capgemini.visseModas.models.dtos.dtos.ClienteDTO;
import br.com.capgemini.visseModas.models.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    //não precisa excluir cliente

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {

        Cliente cliente = form.formToCliente();
        service.salvar(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteUpdate> alterar(@PathVariable Long id, @RequestBody @Valid ClienteUpdate form, UriComponentsBuilder uriBuilder ) {

        Cliente cliente = form.clienteUpdateToCliente();
        service.alterar(id, form);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteUpdate(cliente));

    }

//    //deletar
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deletar(@PathVariable Long id) {
//        return service.inativar(id);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> detalhar(@PathVariable Long id) {
        return service.detalhar(id);
    }

    @GetMapping
    public List<ClienteDTO> listarTudo() {
        return service.listarTudoDTO();
    }
                                                                                            //se não obrigatorio
    @GetMapping("paginacao")                         //avisando o Spring sobre os parametros de url (required = false)
    public Page<ClienteDTO> listarTudoPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {

        Pageable paginacao = PageRequest.of(pagina, quantidade);
        return service.listarTudoDTOPaginacao(paginacao);
    }

    @GetMapping("paginacaoOrdenada")
    public Page<ClienteDTO> listarTudoPaginacao(@RequestParam int pagina, @RequestParam int quantidade, @RequestParam String ordenacao) {

        Pageable paginacao = PageRequest.of(pagina, quantidade, Sort.Direction.ASC, ordenacao);
        return service.listarTudoDTOPaginacao(paginacao);
    }

    @GetMapping("pageable")                     //setando uma ordenacao default, se não passar parametros
    public Page<ClienteDTO> listarTudoPaginacao(@PageableDefault(sort="nome", direction = Sort.Direction.ASC, page=0, size = 10) Pageable paginacao) {
        return service.listarTudoDTOPaginacao(paginacao);
    }








}


