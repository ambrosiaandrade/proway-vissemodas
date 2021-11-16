package br.com.capgemini.visseModas.models.dtos.form;


import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
public class ItemPedidoForm {

    @NotNull @NotEmpty
    private Produto idProduto;
    private Pedido idPedido;
    private Integer quantidade;
    private Double valorTotal;

    public ItemPedidoForm() {

    }

    public ItemPedido formToItemPedido() {

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(idProduto);
        itemPedido.setPedido(idPedido);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorTotal(valorTotal);

        return itemPedido;

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
