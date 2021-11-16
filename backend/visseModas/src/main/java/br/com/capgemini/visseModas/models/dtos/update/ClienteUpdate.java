package br.com.capgemini.visseModas.models.dtos.update;


import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.TipoCliente;
import br.com.capgemini.visseModas.models.repositories.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//DTO para campos que podem ser alterados
public class ClienteUpdate {

    //@NotNull @NotEmpty @Length(min = 5)
    private String nome;

    //@NotNull @NotEmpty @Length(min = 10)
    private String email;

    public ClienteUpdate() {
    }

    public ClienteUpdate(Cliente cliente) {
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        //cliente.setNome(this.nome);
        //cliente.setEmail(this.email);
    }

    public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.getById(id);

        cliente.setNome(this.nome);
        cliente.setEmail(this.email);

        return cliente;
    }

    public Cliente clienteUpdateToCliente() {

        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setEmail(email);

        return cliente;
    }


}
