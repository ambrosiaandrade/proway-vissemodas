package br.com.capgemini.visseModas.models.dtos.form;


import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ProdutoRepository;
import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProdutoForm {

    @NotBlank
    private String descricao;
    @NotBlank
    private String tamanho;
    @NotBlank
    private BigDecimal valorUnitario;
    @NotBlank
    private String categoria;
    @NotBlank
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

