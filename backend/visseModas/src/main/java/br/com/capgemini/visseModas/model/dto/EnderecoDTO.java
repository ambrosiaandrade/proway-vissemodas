package br.com.capgemini.visseModas.model.dto;

import br.com.capgemini.visseModas.model.entity.Endereco;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoDTO {

    private String cep;
    private String cidade;
    private String bairro;
    private String rua;

    public EnderecoDTO(Endereco endereco) {
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.bairro = endereco.getBairro();
        this.rua = endereco.getRua();
    }

    public static List<EnderecoDTO> converter (List<Endereco> listaEnderecos) {
        return listaEnderecos.stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }

}
