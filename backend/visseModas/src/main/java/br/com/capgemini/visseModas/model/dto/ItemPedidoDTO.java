package br.com.capgemini.visseModas.model.dto;

import br.com.capgemini.visseModas.model.entity.ItemPedido;
import br.com.capgemini.visseModas.model.entity.Produto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ItemPedidoDTO {
    private Produto produto;
    private Integer quantidade;
    private Double valorTotal;

    public ItemPedidoDTO(ItemPedido itemPedido){
        this.produto = itemPedido.getProduto();
        this.quantidade = itemPedido.getQuantidade();
        this.valorTotal = itemPedido.getValorTotal();
    }

    public static List<ItemPedidoDTO> converter (List<ItemPedido> listaItemPedido){
        return listaItemPedido.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
    }

}
