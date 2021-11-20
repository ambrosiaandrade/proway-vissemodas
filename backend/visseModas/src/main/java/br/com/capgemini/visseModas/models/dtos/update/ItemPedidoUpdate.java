//package br.com.capgemini.visseModas.models.dtos.update;
//
//
//import br.com.capgemini.visseModas.models.entities.ItemPedido;
//import br.com.capgemini.visseModas.models.entities.Produto;
//import br.com.capgemini.visseModas.models.repositories.ItemPedidoRepository;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//
//@Getter
//@Setter
//public class ItemPedidoUpdate {
//
//    private Produto produto;
//    private Integer quantidade;
//    private BigDecimal valorTotal;
//
//    public ItemPedidoUpdate(){
//
//    }
//
//    public ItemPedidoUpdate(ItemPedido itemPedido){
//        this.produto = itemPedido.getProduto();
//        this.quantidade = itemPedido.getQuantidade();
//        this.valorTotal = itemPedido.getValorPorItem()Item();
//    }
//    public ItemPedido atualizar(Long id, ItemPedidoRepository itemPedidoRepository){
//        ItemPedido itemPedido = itemPedidoRepository.getById(id);
//
//        itemPedido.setProduto(this.produto);
//        itemPedido.setQuantidade(this.quantidade);
//        itemPedido.setValorItem(this.valorTotal);
//
//        return itemPedido;
//    }
//
//    public ItemPedido itemPedidoUpdateToItemPedido(){
//
//        ItemPedido itemPedido = new ItemPedido();
//
//        itemPedido.setProduto(produto);
//        itemPedido.setQuantidade(quantidade);
//        itemPedido.setValorItem(valorTotal);
//
//        return itemPedido;
//    }
//
//}
