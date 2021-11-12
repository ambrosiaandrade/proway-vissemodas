package br.com.capgemini.visseModas.controller;

import br.com.capgemini.visseModas.controller.service.ItemPedidoService;
import br.com.capgemini.visseModas.model.dtoEntrada.ItemPedidoDTOEntrada;
import br.com.capgemini.visseModas.model.dtoSaida.ItemPedidoDTOSaida;
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
    public List<ItemPedidoDTOSaida> listarTudo() {
        return service.listarTudoDTO();
    }

    @PostMapping //save   //vai no corpo
    public void salvar(@RequestBody ItemPedidoDTOEntrada itemPedidoDTO) {

        //converte o DTO para ItemPedido
        ItemPedido itemPedido = itemPedidoDTO.dtoToItemPedido();
        service.salvar(itemPedido);
    }

    @DeleteMapping("/{id}") //delete
    public void deletar(@PathVariable Long id) {
        service.inativar(id);
        //service.inativar(id);
    }

    @PatchMapping("/{id}") //merge
    public void alterar(@PathVariable Long id, @RequestBody ItemPedidoDTOSaida itemPedidoDTOSaida) {

        //converte o DTO para Item Pedido
        ItemPedido itemPedido = ItemPedidoDTOSaida.dtoToItemPedido();
        itemPedido.setId(id);
        service.alterar(id);
    }





}


