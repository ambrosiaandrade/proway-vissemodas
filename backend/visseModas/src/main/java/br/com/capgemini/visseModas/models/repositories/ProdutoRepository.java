package br.com.capgemini.visseModas.models.repositories;

import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByStatus(Boolean status);



    //@Query("select p from Produto p join p.user u where u.username = :username")
    //List<Produto> findByPedido(@Param("username") String username);



}
