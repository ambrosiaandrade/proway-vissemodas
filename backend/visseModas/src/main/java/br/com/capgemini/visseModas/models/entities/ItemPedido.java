package br.com.capgemini.visseModas.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido pedido;

    private Integer quantidade;
    private BigDecimal valorItem;

    public ItemPedido(int quantidade, Pedido pedido, Produto produto){
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.valorItem = produto.getValorUnitario();
        this.produto = produto;
    }

    //atualiza valor do item
    public BigDecimal getValorItem(){
        return valorItem.multiply(new BigDecimal(quantidade));
    }


}
