package br.com.capgemini.visseModas.models.dtos.form;

import br.com.capgemini.visseModas.models.entities.Endereco;
import lombok.Setter;

@Setter
public class EnderecoForm {

    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private Integer numero;

    public EnderecoForm() {
    }

    public Endereco dtoToEndereco() {

        Endereco endereco = new Endereco();

        endereco.setCep(this.cep);
        endereco.setEstado(this.estado);
        endereco.setCidade(this.cidade);
        endereco.setBairro(this.bairro);
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);

        return endereco;
    }


}
