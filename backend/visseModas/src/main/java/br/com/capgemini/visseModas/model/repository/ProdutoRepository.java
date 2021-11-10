package br.com.capgemini.visseModas.model.repository;

import br.com.capgemini.visseModas.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
