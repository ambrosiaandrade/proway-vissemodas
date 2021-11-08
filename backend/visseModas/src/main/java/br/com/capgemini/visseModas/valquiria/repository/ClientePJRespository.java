package br.com.capgemini.visseModas.valquiria.repository;

import br.com.capgemini.visseModas.valquiria.model.ClientePF;
import br.com.capgemini.visseModas.valquiria.model.ClientePJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePJRespository extends JpaRepository<ClientePJ, Integer> {
}
