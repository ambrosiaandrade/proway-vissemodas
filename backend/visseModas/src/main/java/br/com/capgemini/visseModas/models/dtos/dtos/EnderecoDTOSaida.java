package br.com.capgemini.visseModas.models.dtos.dtos;

import br.com.capgemini.visseModas.models.entities.Endereco;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoDTOSaida {

    private Long id;
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;

    public EnderecoDTOSaida() {
    }

    public EnderecoDTOSaida(Endereco endereco) {
        this.id = endereco.getId();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.bairro = endereco.getBairro();
        this.rua = endereco.getRua();
    }

    public static List<EnderecoDTOSaida> converter (List<Endereco> listaEnderecos) {
        return listaEnderecos.stream().map(EnderecoDTOSaida::new).collect(Collectors.toList());
    }



    public Endereco dtoToEndereco() {

        Endereco endereco = new Endereco();
        endereco.setId(id);
        endereco.setRua(this.rua);
        endereco.setCidade(this.cidade);
        endereco.setCep(this.cep);
        endereco.setBairro(this.bairro);

        return endereco;
    }

}
