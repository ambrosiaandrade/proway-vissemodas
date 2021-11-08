package br.com.capgemini.visseModas.rebeca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // anotação para dizer que essa classe é uma table do Banco de Dados
public class Produto {

    @Id // anotação para dizer que esse atributo é o ID da table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // anotação para dizer que o id é o Primary Key na table Produto
    private Integer id;
    private String descricao;
    private String tamanho;
    private Double valorUnitario;
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setCodigoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", codigoProduto='" + descricao + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", status=" + status +
                '}';
    }
}
