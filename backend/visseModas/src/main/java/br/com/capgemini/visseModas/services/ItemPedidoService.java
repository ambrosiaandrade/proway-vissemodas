package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.response.ItemPedidoDTO;
import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ItemPedidoRepository;
import br.com.capgemini.visseModas.models.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    //atualiza valor do item
    public BigDecimal calcularValorPorItem(ItemPedido itemPedido){

        //pego qual é o produto
        Produto produto = produtoRepository.getById(itemPedido.getProduto().getId());
        //atribui ao valor total dos itens (valor produto * quantidade)
        itemPedido.setValorPorItem(produto.getValorUnitario().multiply(new BigDecimal(itemPedido.getQuantidade())));

        return itemPedido.getValorPorItem();
    }

    //add itens na lista de pedidos
    public List<ItemPedido> adicionarItem(Pedido pedido, ItemPedido item){

        if(item.getProduto().getStatus() == true){
            item.setPedido(pedido);
            item.getPedido().getListaItens().add(item);
            item.getPedido().getValorTotal().add(item.getValorPorItem());
        }

        return pedido.getListaItens();
    }

    //remove itens da lista de pedidos
    public List<ItemPedido> removerItem(ItemPedido item){
        item.getPedido().getValorTotal().subtract(item.getValorPorItem());
        item.getPedido().getListaItens().remove(item);

        return item.getPedido().getListaItens();
    }


    public void salvar(ItemPedido itemPedido){
        itemPedidoRepository.save(itemPedido);
    }

    public ResponseEntity<ItemPedidoDTO> detalhar(Long id){
        Optional<ItemPedido> itemPedidoOptional = itemPedidoRepository.findById(id);
        if(itemPedidoOptional.isPresent()){
            return ResponseEntity.ok(new ItemPedidoDTO(itemPedidoOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public List<ItemPedidoDTO> listarTudoDTO(Long idPedido){
        List<ItemPedido> listaItemPedido = itemPedidoRepository.findByPedidoId(idPedido);
        return ItemPedidoDTO.converter(listaItemPedido);
    }

    //todo ajustar
//    public Page<ItemPedidoDTO> listarTudoDTOPaginacao(Pageable paginacao) {
//        Page<ItemPedido> listaItemPedido = itemPedidoRepository.findAll(paginacao);
//        return ItemPedidoDTO.converterPaginacao(listaItemPedido);
//    }
//
}