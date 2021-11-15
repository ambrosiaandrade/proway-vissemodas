package br.com.capgemini.visseModas.models.dtos.form;

import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.Endereco;
import br.com.capgemini.visseModas.models.entities.TipoCliente;
import br.com.capgemini.visseModas.models.repositories.EnderecoRepository;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
public class ClienteForm {

    @NotNull @NotEmpty //TODO ver validacoes
    private String nome;
    //@CPF
    //private String cpf;
    //@CNPJ
    //private String cnpj;
    private String documento;
    private String tipo;
    @Email
    private String email;
    private String senha;
    //private String cep;

    public ClienteForm(){

    }

    //pega os dados do DTO e cria em um cliente
    public Cliente formToCliente() {

        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setDocumento(documento);
        cliente.setTipoCliente(TipoCliente.valueOf(tipo));
        cliente.setEmail(email);
        cliente.setSenha(senha);

        return cliente;
    }

    //TODO ver esse metodo
    //metodo que devolve com cliente completo, com a lista de enderecos para popular a view
    public Cliente converter(EnderecoRepository enderecoRepository){
        List<Endereco> listaEnderecos = enderecoRepository.findByClienteNome(nome);
        return new Cliente(nome, TipoCliente.valueOf(documento), tipo, email, senha, listaEnderecos);
    }


}
