package br.com.capgemini.visseModas.models.dtos.form;

import br.com.capgemini.visseModas.models.entities.*;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Setter
public class ClienteForm {

    //validates that the property is not null or empty; can be applied to String, Collection, Map or Array values.

    @NotEmpty(message = "O nome do cliente é obrigatório")
    private String nome;
    @CPF(message = "CPF inválido.")
    private String cpf;
    @CNPJ(message = "CNPJ inválido.")
    private String cnpj;
    @NotEmpty(message = "O tipo do cliente é obrigatório.")
    private String tipoCliente;

    public ClienteForm(){

    }

    //pega os dados do DTO e cria em um cliente
    public Cliente formToCliente() {

        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setCnpj(cnpj);
        cliente.setTipoCliente(TipoCliente.valueOf(tipoCliente));

        return cliente;
    }

//    //TODO ver esse metodo
//    //metodo que devolve com cliente completo, com a lista de enderecos para popular a view
//    public Cliente converter(EnderecoRepository enderecoRepository){
//        List<Endereco> listaEnderecos = enderecoRepository.findByClienteNome(nome);
//        return new Cliente(nome, TipoCliente.valueOf(documento), tipoCliente, email, senha, listaEnderecos);
//    }


}
