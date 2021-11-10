package br.com.capgemini.visseModas.model.dto;

import br.com.capgemini.visseModas.model.entity.Pedido;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoDTO {

    private String cliente;
    private String enderecoEntrega;
    private String itensPedidos;
    private enum situacao;
    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    public PedidoDTO(Pedido pedido){

    }

    public static List<PedidoDTO> converter(List<Pedido> listaPedidos){
        return listaPedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }

}
