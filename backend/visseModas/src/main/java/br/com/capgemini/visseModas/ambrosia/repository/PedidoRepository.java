package br.com.capgemini.visseModas.ambrosia.repository;

import br.com.capgemini.visseModas.ambrosia.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
