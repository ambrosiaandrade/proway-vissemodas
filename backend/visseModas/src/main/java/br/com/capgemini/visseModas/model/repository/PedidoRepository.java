package br.com.capgemini.visseModas.model.repository;

import br.com.capgemini.visseModas.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>  {

    //@Query("select p from pedido p where p.situacao = :situacao")
    //List<Pedido> findBySituacao(@Param("situacao") Situacao situacao);



}
