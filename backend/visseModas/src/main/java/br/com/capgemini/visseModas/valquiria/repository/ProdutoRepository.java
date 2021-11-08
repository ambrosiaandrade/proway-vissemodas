package br.com.capgemini.visseModas.valquiria.repository;

import br.com.capgemini.visseModas.valquiria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
