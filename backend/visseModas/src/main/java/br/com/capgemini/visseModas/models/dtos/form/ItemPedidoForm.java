package br.com.capgemini.visseModas.models.dtos.form;


import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.services.ItemPedidoService;
import br.com.capgemini.visseModas.services.PedidoService;
import br.com.capgemini.visseModas.services.ProdutoService;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
public class ItemPedidoForm {

    private Long idPedido;
    private Long idProduto;
    private Integer quantidade;
    private BigDecimal valorItens;

    public ItemPedidoForm() {

    }



    public ItemPedido formToItemPedido(ProdutoService produtoService, ItemPedidoService itemPedidoService) {

        Produto produto = produtoService.buscarPorId(idProduto);

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorPorItem(itemPedidoService.calcularValorPorItem(itemPedido));

        return itemPedido;

    }



    public ItemPedido formToItemPedido(ProdutoService produtoService, PedidoService pedidoService) {

        Produto produto = produtoService.buscarPorId(idProduto);
        Pedido pedido = pedidoService.buscarPorId(idPedido);

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(produto);
        itemPedido.setPedido(pedido);
        itemPedido.setQuantidade(quantidade);
        //itemPedido.setValorPorItem(valorItens);

        return itemPedido;

    }

}
