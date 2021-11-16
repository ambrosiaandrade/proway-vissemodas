package br.com.capgemini.visseModas.models.dtos.update;


import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ItemPedidoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoUpdate {

    private Produto produto;
    private Integer quantidade;
    private Double valorTotal;

    public ItemPedidoUpdate(){

    }

    public ItemPedidoUpdate(ItemPedido itemPedido){
        this.produto = itemPedido.getProduto();
        this.quantidade = itemPedido.getQuantidade();
        this.valorTotal = itemPedido.getValorTotal();
    }
    public ItemPedido atualizar(Long id, ItemPedidoRepository itemPedidoRepository){
        ItemPedido itemPedido = itemPedidoRepository.getById(id);

        itemPedido.setProduto(this.produto);
        itemPedido.setQuantidade(this.quantidade);
        itemPedido.setValorTotal(this.valorTotal);

        return itemPedido;
    }

    public ItemPedido itemPedidoUpdateToItemPedido(){

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorTotal(valorTotal);

        return itemPedido;
    }

}
