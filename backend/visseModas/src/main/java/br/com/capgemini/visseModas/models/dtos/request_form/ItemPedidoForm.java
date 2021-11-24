package br.com.capgemini.visseModas.models.dtos.request_form;

import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.services.ItemPedidoService;
import br.com.capgemini.visseModas.services.ProdutoService;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
public class ItemPedidoForm {

    //@NotNull
    private Long idPedido;
    @NotNull
    private Long idProduto;
    @Min(1) //todo pesquisar
    private Integer quantidade;
    @Digits(integer=9, fraction=2)
    private BigDecimal valorTotalItem;

    public ItemPedidoForm() {

    }

    public ItemPedido formToItemPedido(ProdutoService produtoService, ItemPedidoService itemPedidoService) {

        Produto produto = produtoService.buscarPorId(idProduto);

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setValorPorItem(valorTotalItem);
        //itemPedido.setValorPorItem(itemPedidoService.calcularValorPorItem(itemPedido));

        return itemPedido;

    }

//    public List<ItemPedido> converterListaItemPedidoDTOParaListaItemPedido(ProdutoService produtoService, Pedido pedido, List<ItemPedidoForm> lista) {
//
//        List<ItemPedido> listaItens = lista.stream()
//                .map(itemPedidoForm -> {
//
//                    ItemPedido itemPedido = new ItemPedido();
//
//                    itemPedido.setProduto(produtoService.buscarPorId(itemPedidoForm.getIdProduto()));
//                    itemPedido.setPedido(pedido);
//                    itemPedido.setQuantidade(itemPedidoForm.getQuantidade());
//                    itemPedido.setValorPorItem(itemPedidoForm.getValorTotalItem());
//                    return itemPedido;
//                }).collect(Collectors.toList());
//
//        return listaItens;
//
//    }

    }






