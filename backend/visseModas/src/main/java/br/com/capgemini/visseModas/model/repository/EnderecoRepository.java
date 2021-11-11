package br.com.capgemini.visseModas.model.repository;


import br.com.capgemini.visseModas.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
