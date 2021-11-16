package br.com.capgemini.visseModas.models.dtos.form;


import br.com.capgemini.visseModas.models.entities.Produto;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
public class ProdutoForm {

    @NotNull @NotEmpty //TODO ver validacoes
    private String descricao;
    private String tamanho;
    private Double valorUnitario;

    public ProdutoForm(){

    }

    public Produto converteFormParaProduto() {

        Produto produto = new Produto();

        produto.setDescricao(descricao);
        produto.setTamanho(tamanho);
        produto.setValorUnitario(valorUnitario);

        return produto;
    }



}
