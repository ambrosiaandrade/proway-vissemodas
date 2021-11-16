package br.com.capgemini.visseModas.models.dtos.dtos;

import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ClienteRepository;
import br.com.capgemini.visseModas.models.repositories.ProdutoRepository;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProdutoDTO {

    private Long id;
    private String descricao;
    private String tamanho;
    private Double valorUnitario;
    private Boolean status;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto){
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.valorUnitario = produto.getValorUnitario();
        this.tamanho = produto.getTamanho();
        this.status = produto.getStatus();
    }

    public Produto converteDTOParaProduto() {

        Produto produto = new Produto();

        produto.setId(id);
        produto.setDescricao(descricao);
        produto.setTamanho(tamanho);
        produto.setValorUnitario(valorUnitario);

        return produto;
    }


    public Produto atualizar(Long id, ProdutoRepository produtoRepository) {

        Produto produto = produtoRepository.getById(id);

        produto.setDescricao(descricao);
        produto.setTamanho(tamanho);
        produto.setValorUnitario(valorUnitario);

        return produto;
    }


    // Método que converte a entidade para DTO
    public static List<ProdutoDTO> converter(List<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

}
