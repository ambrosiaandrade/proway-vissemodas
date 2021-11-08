package br.com.capgemini.visseModas.amanda.repository;

import br.com.capgemini.visseModas.valquiria.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}