package br.com.capgemini.visseModas.maressa.repository;

import br.com.capgemini.visseModas.maressa.model.entity.ItensPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido,Long> {
}
