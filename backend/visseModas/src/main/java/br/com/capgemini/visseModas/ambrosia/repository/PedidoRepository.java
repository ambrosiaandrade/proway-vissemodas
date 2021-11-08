package br.com.capgemini.visseModas.ambrosia.repository;

import br.com.capgemini.visseModas.ambrosia.model.Pedido;
import br.com.capgemini.visseModas.ambrosia.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository substitui a DAO e tudo que é de banco é aqui
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Método criado pois não está dentro dos métodos nativos
    //@Query("select p from pedido p where p.situacao = :situacao")
    //List<Pedido> findBySituacao(@Param("situacao") Situacao situacao);

}
