package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.models.dtos.dtos.ItemPedidoDTO;
import br.com.capgemini.visseModas.models.dtos.form.ItemPedidoForm;
import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.services.ItemPedidoService;
import br.com.capgemini.visseModas.services.PedidoService;
import br.com.capgemini.visseModas.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itemPedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("calcularItem")
    public BigDecimal calcularValorPorItem(@RequestBody ItemPedidoForm form){
        ItemPedido itemPedido = form.formToItemPedido(produtoService);
        return itemPedidoService.calcularValorPorItem(itemPedido);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoDTO> salvar(@RequestBody ItemPedidoForm form, UriComponentsBuilder uriBuilder) {

        //converte o DTO para ItemPedido
        ItemPedido itemPedido = form.formToItemPedido(produtoService, pedidoService);
        itemPedidoService.salvar(itemPedido);

        URI uri = uriBuilder.path("/itempedido/{id}").buildAndExpand(itemPedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new ItemPedidoDTO(itemPedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> detalhar(@PathVariable Long id) {
        return itemPedidoService.detalhar(id);
    }

    @GetMapping //findAll
    public List<ItemPedidoDTO> listarTudo(Pedido pedido) {
        return itemPedidoService.listarTudoDTO(pedido);
    }

//    @GetMapping("pageable")
//    public Page<ItemPedidoDTO> listarTudoPaginacao(@PageableDefault(sort="descricao", direction = Sort.Direction.ASC, page = 0, size = 10)Pageable paginacao){
//        return itemPedidoService.listarTudoDTOPaginacao(paginacao);
//    }
}


