package br.com.capgemini.visseModas.valquiria.repository;

import br.com.capgemini.visseModas.amanda.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
