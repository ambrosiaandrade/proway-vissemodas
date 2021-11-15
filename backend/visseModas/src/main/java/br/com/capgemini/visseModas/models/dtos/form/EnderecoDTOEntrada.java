package br.com.capgemini.visseModas.models.dtos.form;

import br.com.capgemini.visseModas.models.entities.Endereco;

public class EnderecoDTOEntrada {

    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private String nomeCliente;

    public EnderecoDTOEntrada() {
    }

    public EnderecoDTOEntrada(Endereco endereco) {
        endereco.setRua(this.rua);
        endereco.setCidade(this.cidade);
        endereco.setCep(this.cep);
        endereco.setBairro(this.bairro);
    }

//    public static List<EnderecoDTOEntrada> converter (List<Endereco> listaEnderecos) {
//        return listaEnderecos.stream().map(EnderecoDTOEntrada::new).collect(Collectors.toList());
//    }

    public Endereco dtoToEndereco() {

        Endereco endereco = new Endereco();
        endereco.setRua(this.rua);
        endereco.setCidade(this.cidade);
        endereco.setCep(this.cep);
        endereco.setBairro(this.bairro);

        return endereco;
    }


}
