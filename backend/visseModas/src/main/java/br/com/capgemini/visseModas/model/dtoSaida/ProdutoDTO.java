package br.com.capgemini.visseModas.model.dtoSaida;

import br.com.capgemini.visseModas.model.entity.Produto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProdutoDTO {

    // NÃO USAR ATRIBUTOS DO TIPO COMPLEXO
    private String descricao;
    private String tamanho;
    private Double valorUnitario;
    private Boolean status;

    public ProdutoDTO(Produto produto){
        this.descricao = produto.getDescricao();
        this.valorUnitario = produto.getValorUnitario();
        this.tamanho = produto.getTamanho();
        this.status = produto.getStatus();
    }

    // Método que converte a entidade para DTO
    public static List<ProdutoDTO> converter(List<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

}
