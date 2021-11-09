package br.com.capgemini.visseModas.valquiria.model.repository;

import br.com.capgemini.visseModas.valquiria.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
