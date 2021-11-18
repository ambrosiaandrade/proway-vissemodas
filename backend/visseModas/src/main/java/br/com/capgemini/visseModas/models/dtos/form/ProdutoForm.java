package br.com.capgemini.visseModas.models.dtos.form;


import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ProdutoRepository;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
public class ProdutoForm {

    @NotEmpty
    private String descricao;
    @NotEmpty
    private String tamanho;
    private BigDecimal valorUnitario;
    private String categoria;
    private String imagem;


    public ProdutoForm(){

    }

    public Produto converteFormParaProduto() {

        Produto produto = new Produto();

        produto.setDescricao(descricao);
        produto.setTamanho(tamanho);
        produto.setValorUnitario(valorUnitario);
        produto.setCategoria(categoria);
        produto.setImagem(imagem);

        return produto;
    }


    public Produto atualizar(Long id, ProdutoRepository produtoRepository) {

            Produto produto = produtoRepository.getById(id);

            produto.setDescricao(descricao);
            produto.setTamanho(tamanho);
            produto.setValorUnitario(valorUnitario);
            produto.setCategoria(categoria);
            produto.setImagem(imagem);

            return produto;
        }



    }

