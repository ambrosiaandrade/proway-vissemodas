package br.com.capgemini.visseModas.models.dtos.form;


import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.services.PedidoService;
import br.com.capgemini.visseModas.services.ProdutoService;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
public class ItemPedidoForm {

    private Long idProduto;
    private Long idPedido;
    private Integer quantidade;
    private BigDecimal valorTotal;

    public ItemPedidoForm() {

    }

    public ItemPedido formToItemPedido(ProdutoService produtoService, PedidoService pedidoService) {

        Produto produto = produtoService.buscarPorId(idProduto);
        Pedido pedido = pedidoService.buscarPorId(idPedido);

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(produto);
        itemPedido.setPedido(pedido);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorItem(valorTotal);

        return itemPedido;

    }

}
