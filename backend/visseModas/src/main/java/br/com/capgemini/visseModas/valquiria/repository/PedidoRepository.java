package br.com.capgemini.visseModas.valquiria.repository;

import br.com.capgemini.visseModas.valquiria.model.Pedido;
import br.com.capgemini.visseModas.valquiria.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>  {

    //@Query("select p from pedido p where p.situacao = :situacao")
    //List<Pedido> findBySituacao(@Param("situacao") Situacao situacao);



}
