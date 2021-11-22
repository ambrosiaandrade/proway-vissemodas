package br.com.capgemini.visseModas.models.dtos.dtos;

import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.Endereco;
import br.com.capgemini.visseModas.models.entities.TipoCliente;
import br.com.capgemini.visseModas.services.EnderecoService;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String cnpj;
    private String tipoCliente;
    private Long idEndereco;

    public ClienteDTO() {
    }

    //alimenta o DTO com o Cliente que vem do banco de dados
    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.cnpj = cliente.getCnpj();
        this.tipoCliente = cliente.getTipoCliente().name();
        this.idEndereco = cliente.getEndereco().getId();
    }

    //metodo que converte a Lista de Clientes para Lista de Clientes DTO
    public static List<ClienteDTO> converter(List<Cliente> listaClientes){
        return listaClientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public static Page<ClienteDTO> converterPaginacao(Page<Cliente> listaClientes){
        return listaClientes.map(ClienteDTO::new);
    }


    public Cliente converteDTOParaCliente(EnderecoService enderecoService) {

        Endereco endereco = enderecoService.buscarPorId(idEndereco);

        Cliente cliente = new Cliente();

        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setTipoCliente(TipoCliente.valueOf(tipoCliente));
        cliente.setCpf(cpf);
        cliente.setCnpj(cnpj);
        cliente.setEndereco(endereco);

        return cliente;
    }


}
