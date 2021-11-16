package br.com.capgemini.visseModas.models.dtos.dtos;

import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ItemPedidoDTO {

    private Long id;
    private Produto produto;
    private Pedido pedido;
    private Integer quantidade;
    private Double valorTotal;

    public ItemPedidoDTO(){

    }
    public ItemPedidoDTO(ItemPedido itemPedido){
        this.id = itemPedido.getId();
        this.produto = itemPedido.getProduto();
        this.pedido = itemPedido.getPedido();
        this.quantidade = itemPedido.getQuantidade();
        this.valorTotal = itemPedido.getValorTotal();
    }

    public static List<ItemPedidoDTO> converter (List<ItemPedido> listaItemPedido){
        return listaItemPedido.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
    }

    public ItemPedido dtoToItemPedido(){
        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setId(id);
        itemPedido.setProduto(produto);
        itemPedido.setPedido(pedido);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorTotal(valorTotal);

        return itemPedido;
    }

}
