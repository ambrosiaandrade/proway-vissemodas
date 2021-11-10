package br.com.capgemini.visseModas.model.repository;

import main.java.br.com.capgemini.visseModas.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
