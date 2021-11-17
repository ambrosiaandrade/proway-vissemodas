package br.com.capgemini.visseModas.models.dtos.form;

import br.com.capgemini.visseModas.models.entities.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@GroupSequenceProvider(ClienteGroupSequenceProvider.class)
public class ClienteForm {

    //validates that the property is not null or empty; can be applied to String, Collection, Map or Array values.
    //TODO validar cpf e cnpj
    @NotEmpty(message = "O nome do cliente é obrigatório")
    private String nome;

    @NotEmpty(message = "CPF/CNPJ é obrigatório.")
    @CPF(groups = CPFGroup.class)
    @CNPJ(groups = CNPJGroup.class)
    @Column(name = "documento")
    private String documento;

    //@NotEmpty(message = "O tipo do cliente é obrigatório.")
    private TipoCliente tipoCliente;
    @Email(message = "O email deve ser válido.")
    private String email;
    @NotEmpty(message = "A senha do cliente é obrigatória.")
    private String senha;


//    private String cpf;
//    private String cnpj;

    public ClienteForm(){

    }

    //pega os dados do DTO e cria em um cliente
    public Cliente formToCliente() {

        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        //verificaTipo();
        cliente.setDocumento(documento);
        //cliente.setTipoCliente(TipoCliente.valueOf(tipoCliente));
        cliente.setEmail(email);
        cliente.setSenha(senha);

        return cliente;
    }

//    public void verificaTipo(){
//        if(tipo.equals(TipoCliente.FISICA)){
//            cpf = documento;
//        }else {
//            cnpj = documento;
//        }
//    }


//    //TODO ver esse metodo
//    //metodo que devolve com cliente completo, com a lista de enderecos para popular a view
//    public Cliente converter(EnderecoRepository enderecoRepository){
//        List<Endereco> listaEnderecos = enderecoRepository.findByClienteNome(nome);
//        return new Cliente(nome, TipoCliente.valueOf(documento), tipoCliente, email, senha, listaEnderecos);
//    }


}
