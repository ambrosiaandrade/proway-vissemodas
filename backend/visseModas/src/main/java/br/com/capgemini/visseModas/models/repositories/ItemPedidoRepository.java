package br.com.capgemini.visseModas.models.repositories;

import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

    //saber quais itens tem produto buscado
    List<ItemPedido>findByProdutoId(Long idProduto);

    List<ItemPedido>findByPedidoId(Long id);



}
