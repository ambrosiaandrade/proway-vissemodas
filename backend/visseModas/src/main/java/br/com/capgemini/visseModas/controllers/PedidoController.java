package br.com.capgemini.visseModas.controllers;
import br.com.capgemini.visseModas.models.dtos.dtos.PedidoDTO;
import br.com.capgemini.visseModas.models.dtos.form.PedidoForm;
import br.com.capgemini.visseModas.models.dtos.update.ClienteUpdate;
import br.com.capgemini.visseModas.models.dtos.update.PedidoUpdate;
import br.com.capgemini.visseModas.services.PedidoService;
import br.com.capgemini.visseModas.models.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping //metodo que salva e devolve uma reposta ao invés de ser void   //vai no corpo
    public ResponseEntity<PedidoDTO> salvar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder) {

        Pedido pedido = form.formToPedido();
        service.salvar(pedido);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
    }

    // alterar
    @PatchMapping("/{id}")
    public ResponseEntity<PedidoUpdate> alterar(@PathVariable Long id, @RequestBody @Valid PedidoUpdate form, UriComponentsBuilder uriBuilder) {

        Pedido pedido = form.pedidoUpdateToPedido();
        service.alterar(id, form);

        URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoUpdate(pedido));
    }

    @DeleteMapping("/{id}") //delete
    public ResponseEntity<?> remover (@PathVariable Long id) {
        return service.inativar(id);
    }

    //buscar cliente por id
    @GetMapping("{/id}")
    public ResponseEntity<PedidoDTO> detalhar(@PathVariable Long id){
        return service.detalhar(id);
    }

    @GetMapping //findAll
    public List<PedidoDTO> listarTudo() {
        return service.listarTudoDTO();
    }

}