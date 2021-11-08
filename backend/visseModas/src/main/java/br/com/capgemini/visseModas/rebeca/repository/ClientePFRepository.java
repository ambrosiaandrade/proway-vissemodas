package br.com.capgemini.visseModas.rebeca.repository;

import br.com.capgemini.visseModas.valquiria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientePFRepository extends JpaRepository<Cliente, Integer> {
}
