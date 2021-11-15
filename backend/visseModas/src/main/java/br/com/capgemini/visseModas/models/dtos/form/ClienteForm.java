package br.com.capgemini.visseModas.models.dtos.form;

import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.TipoCliente;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
public class ClienteForm {

    @NotNull @NotEmpty //TODO ver validacoes OK
    private String nome;
    @CPF
    private String cpf;
    @CNPJ
    private String cnpj;
    private String documento;
    private String tipo;
    @Email
    private String email;
    private String senha;


    public ClienteForm(){

    }

    public ClienteForm(Cliente cliente) {

        cliente.setNome(nome);
        cliente.setDocumento(documento);
        cliente.setTipoCliente(TipoCliente.valueOf(tipo));
        cliente.setEmail(email);
        cliente.setSenha(senha);
    }

//    public Cliente dtoToCliente() {
//
//        Cliente cliente = new Cliente();
//
//        cliente.setNome(nome);
//        cliente.setTipoCliente(TipoCliente.valueOf(tipo));
//        cliente.setEmail(email);
//        cliente.setSenha(senha);
//        cliente.setDocumento(documento);
//
//        return cliente;
//    }



}
