package br.com.capgemini.visseModas.controllers;
import br.com.capgemini.visseModas.services.ItemPedidoService;
import br.com.capgemini.visseModas.models.dtos.dtos.ItemPedidoDTO;

import br.com.capgemini.visseModas.models.entities.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService service;

    @GetMapping //findAll
    public List<ItemPedidoDTO> listarTudo() {
        return service.listarTudoDTO();
    }

//    @GetMapping //findAll
//    public List<PedidoDTO> listarTudo() {
//        return service.listarTudoDTO();
//    }

    @PostMapping //save   //vai no corpo
    public void salvar(@RequestBody ItemPedido itemPedido) {
        service.salvar(itemPedido);
    }

    @DeleteMapping("/{id}") //delete
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
        //service.inativar(id);
    }

    @PatchMapping("/{id}") //merge
    public ItemPedido alterar(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {

        ItemPedido itemPedidoAlterado = service.alterar(id);
        return itemPedidoAlterado;

    }





}


