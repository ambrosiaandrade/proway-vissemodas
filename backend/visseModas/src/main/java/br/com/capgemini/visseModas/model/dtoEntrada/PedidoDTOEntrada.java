package br.com.capgemini.visseModas.model.dtoEntrada;

import br.com.capgemini.visseModas.model.entity.Pedido;
import lombok.Setter;

import java.time.LocalDate;

//DTO entrada de dados da view pro banco
@Setter
public class PedidoDTOEntrada {

    private String nomeCliente;
    private String enderecoEntrega;
    private String itensPedidos;
    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    public PedidoDTOEntrada(Pedido pedido){

    }
}
