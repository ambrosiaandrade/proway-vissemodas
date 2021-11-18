/*
package br.com.capgemini.visseModas.models.dtos.update;

import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.repositories.PedidoRepository;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
//DTO para campos que podem ser alterados
public class PedidoUpdate {

    //not null?
    private BigDecimal valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    public PedidoUpdate(){

    }

    public PedidoUpdate(Pedido pedido){
        this.valorTotal = pedido.getValorTotal();
        this.quantidadeTotal = pedido.getQuantidadeTotal();
        this.percentualDesconto = getPercentualDesconto();
    }

    public Pedido atualizar(Long id, PedidoRepository pedidoRepository){
        Pedido pedido = pedidoRepository.getById(id);

        pedido.setValorTotal(this.valorTotal);
        pedido.setQuantidadeTotal(this.quantidadeTotal);
        pedido.setPercentualDesconto(this.percentualDesconto);

        return pedido;
    }

    public Pedido pedidoUpdateToPedido(){
        Pedido pedido = new Pedido();

        pedido.setValorTotal(valorTotal);
        pedido.setQuantidadeTotal(quantidadeTotal);
        pedido.setPercentualDesconto(percentualDesconto);

        return pedido;
    }

}
*/
