package br.com.capgemini.visseModas.rebeca.model;

public class Produto {

    private Integer id;
    private String codigoProduto;
    private String tamanho;
    private Double valorUnitario;
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
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
                ", codigoProduto='" + codigoProduto + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", status=" + status +
                '}';
    }
}
