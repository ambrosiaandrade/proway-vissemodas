package br.com.capgemini.visseModas.luana.repository;

import br.com.capgemini.visseModas.luana.model.ClientePJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePJRepository extends JpaRepository<ClientePJ, Integer> {

}
