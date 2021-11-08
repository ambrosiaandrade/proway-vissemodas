package br.com.capgemini.visseModas.maressa.repository;

import br.com.capgemini.visseModas.rebeca.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
