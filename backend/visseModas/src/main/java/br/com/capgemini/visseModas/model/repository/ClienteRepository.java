package br.com.capgemini.visseModas.model.repository;

import br.com.capgemini.visseModas.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
