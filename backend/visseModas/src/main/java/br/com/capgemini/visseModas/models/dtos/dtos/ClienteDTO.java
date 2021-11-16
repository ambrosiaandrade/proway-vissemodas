package br.com.capgemini.visseModas.models.dtos.dtos;

import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.TipoCliente;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteDTO {

    private Long id;
    private String nome;
    private String documento;
    private String tipoCliente;
    private String email;
    private String senha;

    public ClienteDTO() {
    }

    //alimenta o DTO com o Cliente que vem do banco de dados
    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.documento = cliente.getDocumento();
        this.tipoCliente = cliente.getTipoCliente().name();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
    }

    //metodo que converte a Lista de Clientes para Lista de Clientes DTO
    public static List<ClienteDTO> converter(List<Cliente> listaClientes){
        return listaClientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }


    public Cliente converteDTOParaCliente() {

        Cliente cliente = new Cliente();

        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setTipoCliente(TipoCliente.valueOf(tipoCliente));
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setDocumento(documento);

        return cliente;
    }


}
