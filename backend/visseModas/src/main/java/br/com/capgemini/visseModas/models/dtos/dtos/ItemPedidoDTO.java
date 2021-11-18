package br.com.capgemini.visseModas.models.dtos.dtos;

import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ItemPedidoDTO {

    private Long id;
    private Long idProduto;
    private Long idPedido;
    private Integer quantidade;
    private BigDecimal valorTotal;

    public ItemPedidoDTO(){

    }

    public ItemPedidoDTO(ItemPedido itemPedido){
        this.id = itemPedido.getId();
        this.idProduto = itemPedido.getProduto().getId();
        this.idPedido = itemPedido.getPedido().getId();
        this.quantidade = itemPedido.getQuantidade();
        this.valorTotal = itemPedido.getValorItem();
    }

    public static List<ItemPedidoDTO> converter (List<ItemPedido> listaItemPedido){
        return listaItemPedido.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
    }

//    public ItemPedido dtoToItemPedido(Pedido pedido, Produto produto){
//
//        ItemPedido itemPedido = new ItemPedido(quantidade, pedido, produto);
//
//        itemPedido.setId(id);
//        itemPedido.setProduto(produto);
//        itemPedido.setPedido(pedido);
//        itemPedido.setQuantidade(quantidade);
//        itemPedido.setValorItem(valorTotal);
//
//        return itemPedido;
//    }

}
