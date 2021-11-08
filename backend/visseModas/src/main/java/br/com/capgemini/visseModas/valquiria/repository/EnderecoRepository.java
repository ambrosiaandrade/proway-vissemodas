package br.com.capgemini.visseModas.valquiria.repository;

import br.com.capgemini.visseModas.valquiria.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
