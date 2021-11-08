package br.com.capgemini.visseModas.amanda.repository;

import br.com.capgemini.visseModas.amanda.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // para dizer ao Spring que essa interface será Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    // entre o <> passa qual é o modelo (Pedido) e qual é o tipo da chave primária da entidade
}
