package br.com.capgemini.visseModas.models.dtos.dtos;

import br.com.capgemini.visseModas.models.entities.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// DTO saída de dados do banco para a view
@Getter
public class PedidoDTO {

    private Long id;
    private LocalDate data;
    private String nomeCliente;
    private List<ItemPedido> listaItens;
    private Situacao situacao;
    private BigDecimal valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    public PedidoDTO(){

    }

    public PedidoDTO(Pedido pedido){

        this.id = pedido.getId();
        this.data = pedido.getData();
        this.listaItens = pedido.getListaItens();
        this.nomeCliente = pedido.getCliente().getNome();
        this.situacao = pedido.getSituacao();
        this.valorTotal = pedido.getValorTotal();
        this.quantidadeTotal = pedido.getQuantidadeTotal();
        this.percentualDesconto = pedido.getPercentualDesconto();
    }

    public static List<PedidoDTO> converter(List<Pedido> listaPedidos){
        return listaPedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }

}
