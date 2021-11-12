package br.com.capgemini.visseModas.model.dtoSaida;

import br.com.capgemini.visseModas.model.entity.Cliente;
import br.com.capgemini.visseModas.model.entity.TipoCliente;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteDTOSaida {

    private Long id;
    private String nome;
    private String documento;
    //private String tipo;
    private String email;
    private String senha;

    public ClienteDTOSaida() {
    }

    public ClienteDTOSaida(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.documento = cliente.getDocumento();
        //this.tipo = cliente.getTipoCliente().name();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
    }

    //metodo que converte a entidade para DTO
    public static List<ClienteDTOSaida> converter(List<Cliente> listaClientes){
        return listaClientes.stream().map(ClienteDTOSaida::new).collect(Collectors.toList());
    }

    public Cliente dtoToCliente() {

        Cliente cliente = new Cliente();

        cliente.setId(id);
        cliente.setNome(nome);
        //cliente.setTipoCliente(TipoCliente.valueOf(tipo));
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setDocumento(documento);

        return cliente;
    }


}
