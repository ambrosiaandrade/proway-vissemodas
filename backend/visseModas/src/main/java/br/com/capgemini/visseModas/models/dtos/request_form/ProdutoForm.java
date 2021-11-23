package br.com.capgemini.visseModas.models.dtos.request_form;


import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ProdutoRepository;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class ProdutoForm {

    @NotBlank
    private String descricao;
    @NotBlank
    private String tamanho;
    
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


    public Produto atualizarProduto(Long id, ProdutoRepository produtoRepository) {

            Produto produto = produtoRepository.getById(id);

            produto.setDescricao(descricao);
            produto.setTamanho(tamanho);
            produto.setValorUnitario(valorUnitario);
            produto.setCategoria(categoria);
            produto.setImagem(imagem);

            return produto;
        }



    }

