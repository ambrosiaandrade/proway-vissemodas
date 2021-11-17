package br.com.capgemini.visseModas.models.dtos.dtos;

import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.Endereco;
import br.com.capgemini.visseModas.models.entities.Pedido;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// DTO saída de dados do banco para a view
@Getter
public class PedidoDTO {

    private Long id;
    private LocalDate data;
    private String nomeCliente;
    private String cep;
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

    public PedidoDTO(Pedido pedido, Cliente cliente, Endereco endereco){
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.nomeCliente = cliente.getNome();
        this.cep = endereco.getCep();
        this.situacao = pedido.getSituacao();
        this.valorTotal = pedido.getValorTotal();
        this.quantidadeTotal = pedido.getQuantidadeTotal();
        this.percentualDesconto = pedido.getPercentualDesconto();
    }


    public static List<PedidoDTO> converter(List<Pedido> listaPedidos){
        return listaPedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }

}
