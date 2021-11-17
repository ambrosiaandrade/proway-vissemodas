package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.models.dtos.dtos.ItemPedidoDTO;
import br.com.capgemini.visseModas.models.dtos.form.ItemPedidoForm;
import br.com.capgemini.visseModas.models.dtos.update.ItemPedidoUpdate;
import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService service;


    @PostMapping //save   //vai no corpo
    public ResponseEntity<ItemPedidoDTO> salvar(@RequestBody ItemPedidoForm form, UriComponentsBuilder uriBuilder) {

        //converte o DTO para ItemPedido
        ItemPedido itemPedido = form.formToItemPedido();
        service.salvar(itemPedido);

        URI uri = uriBuilder.path("/itempedido/{id}").buildAndExpand(itemPedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new ItemPedidoDTO(itemPedido));
    }

    @PatchMapping("/{id}") //merge
    public ResponseEntity<ItemPedidoUpdate> alterar(@PathVariable Long id, @RequestBody @Valid ItemPedidoUpdate form, UriComponentsBuilder uriBuilder) {

        //converte o DTO para Item Pedido
        ItemPedido itemPedido = form.itemPedidoUpdateToItemPedido();
        service.alterar(id,form);
        URI uri = uriBuilder.path("/itempedido/{id}").buildAndExpand(itemPedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new ItemPedidoUpdate(itemPedido));
    }

    @DeleteMapping("/{id}") //analisar como fazer o método de remover ítem do pedido
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return service.inativar(id);
        //service.inativar(id);
    }

    @GetMapping("/{id}") //findAll
    public List<ItemPedidoDTO> detalhar(@PathVariable Long id) {
        return (List<ItemPedidoDTO>) service.detalhar(id);
    }

    @GetMapping //findAll
    public List<ItemPedidoDTO> listarTudo() {
        return service.listarTudoDTO();
    }

}


