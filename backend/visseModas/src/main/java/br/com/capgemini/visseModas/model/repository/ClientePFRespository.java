package br.com.capgemini.visseModas.model.repository;

import br.com.capgemini.visseModas.model.entity.ClientePF;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientePFRespository extends JpaRepository<ClientePF, Long> {
}
