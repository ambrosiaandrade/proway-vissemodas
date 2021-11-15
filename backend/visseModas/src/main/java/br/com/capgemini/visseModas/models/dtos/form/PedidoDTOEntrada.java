package br.com.capgemini.visseModas.models.dtos.form;

import br.com.capgemini.visseModas.models.entities.Pedido;
import lombok.Setter;

//DTO entrada de dados da view pro banco
@Setter
public class PedidoDTOEntrada {

    private String idCliente;
    private String enderecoEntrega;
    private String itensPedidos;
    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    public PedidoDTOEntrada(){

    }

    public PedidoDTOEntrada(Pedido pedido){

        //pedido.idCliente
        //pedido.setEndereco
        //pedido.setItensPedidos
        pedido.setValorTotal(valorTotal);
        pedido.setQuantidadeTotal(quantidadeTotal);
        pedido.setPercentualDesconto(percentualDesconto);

    }




}