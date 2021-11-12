package br.com.capgemini.visseModas.model.dtoEntrada;

import br.com.capgemini.visseModas.model.entity.ItemPedido;
import br.com.capgemini.visseModas.model.entity.Pedido;
import br.com.capgemini.visseModas.model.entity.Produto;
import lombok.Setter;

@Setter
public class ItemPedidoDTOEntrada {
    private Produto idProduto;
    private Pedido idPedido;
    private Integer quantidade;
    private Double valorTotal;

    public ItemPedidoDTOEntrada() {

    }

    public ItemPedidoDTOEntrada(ItemPedido itemPedido) {
        Produto produto = new Produto();
        itemPedido.setProduto(idProduto);
        itemPedido.setPedido(idPedido);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorTotal(valorTotal);

    }

    public ItemPedido dtoToItemPedido() {

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(idProduto);
        itemPedido.setPedido(idPedido);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorTotal(valorTotal);

        return itemPedido;
    }
}
