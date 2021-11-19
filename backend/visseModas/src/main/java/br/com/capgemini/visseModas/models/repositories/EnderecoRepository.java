package br.com.capgemini.visseModas.models.repositories;


import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findByCep(String cep);

    //busca os enderecos do cliente
    //List<Endereco> findByClienteNome(String nomeCliente);
}
