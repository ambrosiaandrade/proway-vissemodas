package br.com.capgemini.visseModas.model.dtoSaida;

import br.com.capgemini.visseModas.model.entity.ItemPedido;
import br.com.capgemini.visseModas.model.entity.Produto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ItemPedidoDTOSaida {

    private Long id;
    private Produto produto;
    private Integer quantidade;
    private Double valorTotal;

    public ItemPedidoDTOSaida(){

    }

    public ItemPedidoDTOSaida(ItemPedido itemPedido){
        this.id = itemPedido.getId();
        this.produto = itemPedido.getProduto();
        this.quantidade = itemPedido.getQuantidade();
        this.valorTotal = itemPedido.getValorTotal();
    }

    public static List<ItemPedidoDTOSaida> converter (List<ItemPedido> listaItemPedido){
        return listaItemPedido.stream().map(ItemPedidoDTOSaida::new).collect(Collectors.toList());
    }

    /*public static ItemPedido dtoToItemPedido() {
        //estudar mais um pouco como fazer essa parte
        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setId(id);
        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorTotal(valorTotal);

        return itemPedido;
    }*/
}
