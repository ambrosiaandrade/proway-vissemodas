package br.com.capgemini.visseModas.model.dtoSaida;

import br.com.capgemini.visseModas.model.entity.Cliente;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteDTOSaida {

    private Long id;
    private String nome;
    private String cpf;
    private String cnpj;
    private String tipo;
    private String email;
    private String senha;

    public ClienteDTOSaida(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.cnpj = cliente.getCnpj();
        this.tipo = cliente.getTipoCliente().name();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
    }

    //metodo que converte a entidade para DTO
    public static List<ClienteDTOSaida> converter(List<Cliente> listaClientesPF){
        return listaClientesPF.stream().map(ClienteDTOSaida::new).collect(Collectors.toList());
    }



}
