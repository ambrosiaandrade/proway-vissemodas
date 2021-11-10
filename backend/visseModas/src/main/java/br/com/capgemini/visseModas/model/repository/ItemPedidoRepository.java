package br.com.capgemini.visseModas.model.repository;

import br.com.capgemini.visseModas.model.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
