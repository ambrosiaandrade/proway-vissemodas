package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.models.dtos.dtos.ItemPedidoDTO;
import br.com.capgemini.visseModas.models.dtos.form.ItemPedidoForm;
import br.com.capgemini.visseModas.models.dtos.update.ItemPedidoUpdate;
import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.services.ItemPedidoService;
import br.com.capgemini.visseModas.services.PedidoService;
import br.com.capgemini.visseModas.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService service;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ProdutoService produtoService;


    @PostMapping
    public ResponseEntity<ItemPedidoDTO> salvar(@RequestBody ItemPedidoForm form, UriComponentsBuilder uriBuilder) {

        //converte o DTO para ItemPedido
        ItemPedido itemPedido = form.formToItemPedido(produtoService, pedidoService);
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
    public ResponseEntity<ItemPedidoDTO> detalhar(@PathVariable Long id) {
        return service.detalhar(id);
    }

    @GetMapping //findAll
    public List<ItemPedidoDTO> listarTudo() {
        return service.listarTudoDTO();
    }

    @GetMapping("pageable")
    public Page<ItemPedidoDTO> listarTudoPaginacao(@PageableDefault(sort="id", direction = Sort.Direction.ASC, page = 0, size = 10)Pageable paginacao){
        return service.listarTudoDTOPaginacao(paginacao);
    }
}


