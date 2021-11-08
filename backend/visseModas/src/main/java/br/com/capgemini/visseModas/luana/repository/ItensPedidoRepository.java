package br.com.capgemini.visseModas.luana.repository;

import br.com.capgemini.visseModas.luana.model.ItensPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Integer> {

}
