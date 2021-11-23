package br.com.capgemini.visseModas.models.dtos.request_form;

import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.services.ItemPedidoService;
import br.com.capgemini.visseModas.services.ProdutoService;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ItemPedidoForm {

    private Long idPedido;
    private Long idProduto;
    //@Min() //todo pesquisar
    private Integer quantidade;
    private BigDecimal valorTotalItem;

    public ItemPedidoForm() {

    }

    public ItemPedido formToItemPedido(ProdutoService produtoService, ItemPedidoService itemPedidoService) {

        Produto produto = produtoService.buscarPorId(idProduto);

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorPorItem(valorTotalItem);
        //itemPedido.setValorPorItem(itemPedidoService.calcularValorPorItem(itemPedido));

        return itemPedido;

    }

//    public List<ItemPedido> converterListaItemPedidoDTOParaListaItemPedido(ProdutoService produtoService, Pedido pedido, List<ItemPedidoForm> lista) {
//
//        List<ItemPedido> listaItens = lista.stream()
//                .map(itemPedidoForm -> {
//
//                    ItemPedido itemPedido = new ItemPedido();
//
//                    itemPedido.setProduto(produtoService.buscarPorId(itemPedidoForm.getIdProduto()));
//                    itemPedido.setPedido(pedido);
//                    itemPedido.setQuantidade(itemPedidoForm.getQuantidade());
//                    itemPedido.setValorPorItem(itemPedidoForm.getValorTotalItem());
//                    return itemPedido;
//                }).collect(Collectors.toList());
//
//        return listaItens;
//
//    }

    }






