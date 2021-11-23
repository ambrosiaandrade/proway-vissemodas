package br.com.capgemini.visseModas.models.dtos.dtos;

import br.com.capgemini.visseModas.models.entities.*;
import br.com.capgemini.visseModas.models.repositories.ItemPedidoRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// DTO saída de dados do banco para a view
@Getter
public class PedidoDTO {

    private Long id;
    private LocalDate data;
    private String nomeCliente;
    //private ClienteDTO clienteDTO;
    private Situacao situacao;
    private BigDecimal valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;
    private List<ItemPedidoDTO> listaItens = new ArrayList<>();

    public PedidoDTO(){

    }

    public PedidoDTO(Pedido pedido){

        this.id = pedido.getId();
        this.data = pedido.getData();

        //clienteDTO = new ClienteDTO(pedido.getCliente());
        nomeCliente = pedido.getCliente().getNome();

        this.situacao = pedido.getSituacao();
        this.valorTotal = pedido.getValorTotal();
        this.quantidadeTotal = pedido.getQuantidadeTotal();
        this.percentualDesconto = pedido.getPercentualDesconto();

        this.listaItens = ItemPedidoDTO.converter(pedido.getListaItens());
    }

//    public Pedido formToPedido(ClienteService clienteService) {
//
//        Cliente cliente = clienteService.buscarPorNome(nomeCliente);
//
//        ItemPedido itemPedido = new ItemPedido();
//
//        List<ItemPedido> itemPedidoList = itemPedidoDTOList.stream()
//                .map(itemPedidoDTO -> {
//                    itemPedido.setQuantidade(quantidadeTotal); //mudar para algo como itemPedido.setQuantidade(itemPedidoDTO.getQuantidade())
//                    itemPedido.setValorItem(valorTotal); //mudar para algo como itemPedido.setValorItem(itemPedidoDTO.getValorItem())
//                    return itemPedido;
//                }).collect(Collectors.toList());
//
//
//        Pedido pedido = new Pedido();
//        pedido.setCliente(cliente);
//        pedido.setListaItens(itemPedidoList);
//        pedido.setValorTotal(valorTotal);
//        pedido.setQuantidadeTotal(quantidadeTotal);
//        pedido.setPercentualDesconto(percentualDesconto);
//
//        return pedido;
//    }




    public static List<PedidoDTO> converter(List<Pedido> listaPedidos){
        return listaPedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }

    public static Page<PedidoDTO> converterPaginacao(Page<Pedido> listaPedidos){
        return listaPedidos.map(PedidoDTO::new);
    }

}
