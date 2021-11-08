package br.com.capgemini.visseModas.maressa.repository;

import br.com.capgemini.visseModas.maressa.model.Pedido;
import br.com.capgemini.visseModas.maressa.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    //@Query("select p from pedido p where p.situacao = :situacao")
    //List<Pedido> findBySituacao(@Param("situacao") Situacao situacao);
}
