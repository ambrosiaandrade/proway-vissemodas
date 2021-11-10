package br.com.capgemini.visseModas.model.dto;

import br.com.capgemini.visseModas.model.entity.ClientePF;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClientePFDTO {

    //NÃO USAR ATRIBUTOS DE TIPO COMPLEXO

    private String nome;
    private String cpf;

    public ClientePFDTO(ClientePF clientePF) {
        this.nome = clientePF.getNome();
        this.cpf = clientePF.getCpf();
    }

    //metodo que converte a entidade para DTO
    public static List<ClientePFDTO> converter(List<ClientePF> listaClientesPF){
        return listaClientesPF.stream().map(ClientePFDTO::new).collect(Collectors.toList());
    }



}