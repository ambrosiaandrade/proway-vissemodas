package br.com.capgemini.visseModas.model.dto;

import br.com.capgemini.visseModas.model.entity.ClientePF;
import br.com.capgemini.visseModas.model.entity.ClientePJ;

import java.util.List;
import java.util.stream.Collectors;

public class ClientePJDTO {

    private String nome;
    private String cnpj;

    public ClientePJDTO(ClientePJ clientePJ) {
        this.nome = clientePJ.getNome();
        this.cnpj = clientePJ.getCnpj();
    }

    //metodo que converte a entidade para DTO
    public static List<ClientePJDTO> converter(List<ClientePJ> listaClientesPJ){
        return listaClientesPJ.stream().map(ClientePJDTO::new).collect(Collectors.toList());
    }

}
