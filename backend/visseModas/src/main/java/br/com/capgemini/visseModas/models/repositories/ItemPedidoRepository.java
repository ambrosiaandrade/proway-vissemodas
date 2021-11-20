package br.com.capgemini.visseModas.models.repositories;

import br.com.capgemini.visseModas.models.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

    //saber quais itens tem produto buscado
    List<ItemPedido> findByProdutoId(Long idProduto);
    //se tiver vazia pode excluir

    List<ItemPedido>findByPedidoId(Long id);


    //List<ItemPedido> findAllItemPedido(Long id);

//    @Query(value = "select ip.pedido_id as 'Número Pedido', ip.id, ip.quantidade, ip.valor_item, p.descricao, p.id " +
//            "from item_pedido ip inner join produto p on ip.produto_id = p.id and p.id = ip.pedido_id", nativeQuery = true)
//    List<ItemPedido> listaItensPersonalizada();

}
