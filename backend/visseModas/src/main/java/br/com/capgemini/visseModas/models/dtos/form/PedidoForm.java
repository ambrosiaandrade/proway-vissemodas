package br.com.capgemini.visseModas.models.dtos.form;

import br.com.capgemini.visseModas.models.entities.Pedido;
import lombok.Setter;

//DTO entrada de dados da view pro banco
@Setter
public class PedidoForm {

    private String idCliente;
    private String enderecoEntrega;
    private String itensPedidos;
    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    public PedidoForm(){

    }

    public Pedido formToPedido(){

        Pedido pedido = new Pedido();

        //pedido.idCliente
        //pedido.setEndereco
        //pedido.setItensPedidos
        pedido.setValorTotal(valorTotal);
        pedido.setQuantidadeTotal(quantidadeTotal);
        pedido.setPercentualDesconto(percentualDesconto);

        return pedido;
    }




}
