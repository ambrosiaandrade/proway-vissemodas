package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.models.dtos.update.ClienteUpdate;
import br.com.capgemini.visseModas.services.ClienteService;
import br.com.capgemini.visseModas.models.dtos.form.ClienteForm;
import br.com.capgemini.visseModas.models.dtos.dtos.ClienteDTO;
import br.com.capgemini.visseModas.models.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    //TODO não precisa excluir

    @Autowired
    private ClienteService service;

    //metodo que salva e devolve uma reposta ao invés de ser void
    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {

        Cliente cliente = form.formToCliente();
        service.salvar(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

    //alterar
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

    //buscar cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> detalhar(@PathVariable Long id) {
        return service.detalhar(id);
    }

    //listar tudo
    @GetMapping
    public List<ClienteDTO> listarTudo() {
        return service.listarTudoDTO();
    }








}


