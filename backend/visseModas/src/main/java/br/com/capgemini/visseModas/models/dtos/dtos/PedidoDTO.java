package br.com.capgemini.visseModas.models.dtos.dtos;

import br.com.capgemini.visseModas.models.entities.Pedido;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//  DTO saída de dados do banco para a view
@Getter
public class PedidoDTO {

    private Long id;
    private LocalDate data;
    private String nomeCliente;
    private String enderecoEntrega;
    private String itensPedidos;
    private Enum situacao;
    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    public PedidoDTO(Pedido pedido){
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.situacao = pedido.getSituacao();
        this.valorTotal = pedido.getValorTotal();
        this.quantidadeTotal = pedido.getQuantidadeTotal();
        this.percentualDesconto = pedido.getPercentualDesconto();
    }

    public static List<PedidoDTOSaida> converter(List<Pedido> listaPedidos){
        return listaPedidos.stream().map(PedidoDTOSaida::new).collect(Collectors.toList());
    }

}
