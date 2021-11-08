package br.com.capgemini.visseModas.luana.repository;

import br.com.capgemini.visseModas.luana.model.ClientePF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePFRepository extends JpaRepository<ClientePF, Integer> {

}
