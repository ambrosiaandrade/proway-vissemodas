package br.com.capgemini.visseModas.controllers;
import br.com.capgemini.visseModas.models.dtos.dtos.PedidoDTO;
import br.com.capgemini.visseModas.models.dtos.form.PedidoForm;
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

    @GetMapping //findAll
    public List<PedidoDTOSaida> listarTudo() {
        return service.listarTudoDTO();
    }

    @DeleteMapping("/{id}") //delete
    public void deletar(@PathVariable Long id) {
        service.inativar(id);
    }

    @PatchMapping("/{id}") //merge
    public Pedido alterar(@PathVariable Long id, @RequestBody Pedido pedido) {

        Pedido pedidoAlterado = service.alterar(id);
        return pedidoAlterado;

    }

}


