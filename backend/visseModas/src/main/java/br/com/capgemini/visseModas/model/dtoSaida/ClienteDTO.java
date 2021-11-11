package br.com.capgemini.visseModas.model.dtoSaida;

import br.com.capgemini.visseModas.model.entity.Cliente;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteDTO {

   //NÃO USAR ATRIBUTOS DE TIPO COMPLEXO

    private String nome;
    private String cpf;
    private String cnpj;

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.cnpj = cliente.getCnpj();
    }

    //metodo que converte a entidade para DTO
    public static List<ClienteDTO> converter(List<Cliente> listaClientesPF){
        return listaClientesPF.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }



}
