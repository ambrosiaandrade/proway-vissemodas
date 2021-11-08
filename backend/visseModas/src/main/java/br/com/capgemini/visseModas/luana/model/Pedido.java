package br.com.capgemini.visseModas.luana.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY) // eager ou lazy --> lazy - não vai carregar todos os pedidos para um cliente de imediato, só se precisar
    private Cliente cliente;

    @ManyToOne()
    private Endereco endereco;
    
    private Situacao situacao;
    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public Double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(Double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", data=" + data +
                ", cliente=" + cliente +
                ", endereco=" + endereco +
                ", situacao=" + situacao +
                ", valorTotal=" + valorTotal +
                ", quantidadeTotal=" + quantidadeTotal +
                ", percentualDesconto=" + percentualDesconto +
                '}';
    }
}
