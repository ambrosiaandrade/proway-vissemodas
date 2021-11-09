package br.com.capgemini.visseModas.maressa.repository;

import br.com.capgemini.visseModas.maressa.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
