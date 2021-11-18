package br.com.capgemini.visseModas.models.dtos.update;

import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ProdutoRepository;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
public class ProdutoUpdate {

    private Long id;
    private String descricao;
    private String tamanho;
    private BigDecimal valorUnitario;
    private String categoria;
    private String imagem;
    private Boolean status;

    public ProdutoUpdate(){

    }

    public ProdutoUpdate(Produto produto){
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.tamanho = produto.getTamanho();
        this.valorUnitario = produto.getValorUnitario();
    }

    public Produto atualizar(Long id, ProdutoRepository produtoRepository){

        Produto produto = produtoRepository.getById(id);

        produto.setId(id);
        produto.setDescricao(descricao);
        produto.setTamanho(tamanho);
        produto.setValorUnitario(valorUnitario);

        return produto;
    }

    public Produto produtoUpdateToProduto(){
        Produto produto = new Produto();

        produto.setId(id);
        produto.setTamanho(tamanho);
        produto.setValorUnitario(valorUnitario);
        produto.setDescricao(descricao);

        return produto;
    }


}
