package br.com.capgemini.visseModas.amanda.model;

public class ItensPedido {
    private Integer id;
    private Produto produto;
    private Pedido pedido;
    private Integer quantidade;
    private Double valorTotal;

    @Override
    public String toString() {
        return "ItensPedido{" +
                "id=" + id +
                ", produto=" + produto +
                ", pedido=" + pedido +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
