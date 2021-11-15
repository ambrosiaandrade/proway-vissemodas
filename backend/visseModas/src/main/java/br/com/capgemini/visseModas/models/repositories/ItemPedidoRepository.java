package br.com.capgemini.visseModas.models.repositories;

import br.com.capgemini.visseModas.models.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
