package br.com.capgemini.visseModas.controllers;
import br.com.capgemini.visseModas.models.dtos.dtos.PedidoDTOSaida;
import br.com.capgemini.visseModas.services.PedidoService;
import br.com.capgemini.visseModas.models.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping //findAll
    public List<PedidoDTOSaida> listarTudo() {
        return service.listarTudoDTO();
    }

    @PostMapping //save   //vai no corpo
    public void salvar(@RequestBody Pedido pedido) {
        service.salvar(pedido);
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


