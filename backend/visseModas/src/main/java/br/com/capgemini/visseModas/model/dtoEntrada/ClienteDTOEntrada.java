package br.com.capgemini.visseModas.model.dtoEntrada;

import br.com.capgemini.visseModas.model.entity.Cliente;
import br.com.capgemini.visseModas.model.entity.TipoCliente;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Setter
public class ClienteDTOEntrada {

   //NÃO USAR ATRIBUTOS DE TIPO COMPLEXO

    private String nome;
    private String cpf;
    private String cnpj;
    private String tipo;
    private String email;
    private String senha;

    public ClienteDTOEntrada(Cliente cliente) {

        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setCnpj(cnpj);
        cliente.setTipoCliente(TipoCliente.valueOf(tipo));
        cliente.setEmail(email);
        cliente.setSenha(senha);
    }

    public ClienteDTOEntrada(){

    }

//    //metodo que converte a entidade para DTO
//    public static List<ClienteDTOEntrada> converter(List<Cliente> listaClientesPF){
//        return listaClientesPF.stream().map(ClienteDTOEntrada::new).collect(Collectors.toList());
//    }

    public Cliente dtoToCliente() {

        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setCnpj(cnpj);
        cliente.setTipoCliente(TipoCliente.valueOf(tipo));
        cliente.setEmail(email);
        cliente.setSenha(senha);

        return cliente;
    }


}
