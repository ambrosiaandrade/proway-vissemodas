package br.com.capgemini.visseModas.model.dtoEntrada;

import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.TipoCliente;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Setter
public class ClienteDTOEntrada {

    private String nome;
    private String documento;
    private String tipo;
    private String email;
    private String senha;


    public ClienteDTOEntrada(){

    }

    public ClienteDTOEntrada(Cliente cliente) {

        cliente.setNome(nome);
        cliente.setDocumento(documento);
        cliente.setTipoCliente(TipoCliente.valueOf(tipo));
        cliente.setEmail(email);
        cliente.setSenha(senha);
    }

    public Cliente dtoToCliente() {

        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setTipoCliente(TipoCliente.valueOf(tipo));
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setDocumento(documento);

        return cliente;
    }


}
