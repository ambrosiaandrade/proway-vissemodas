package br.com.capgemini.visseModas.rebeca.repository;

import br.com.capgemini.visseModas.valquiria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
