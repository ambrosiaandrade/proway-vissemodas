package br.com.capgemini.visseModas.valquiria.model.repository;

import br.com.capgemini.visseModas.valquiria.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
