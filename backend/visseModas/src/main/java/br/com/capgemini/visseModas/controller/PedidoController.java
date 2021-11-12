package br.com.capgemini.visseModas.controller;

import br.com.capgemini.visseModas.controller.service.PedidoService;
import br.com.capgemini.visseModas.model.dtoSaida.PedidoDTOSaida;
import br.com.capgemini.visseModas.model.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
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


