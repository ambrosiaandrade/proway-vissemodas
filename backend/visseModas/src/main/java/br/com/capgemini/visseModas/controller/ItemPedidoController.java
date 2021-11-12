package br.com.capgemini.visseModas.controller;
import br.com.capgemini.visseModas.controller.service.ItemPedidoService;
import br.com.capgemini.visseModas.model.dtoSaida.ItemPedidoDTO;

import br.com.capgemini.visseModas.model.entity.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-pedido")
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


