package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.response.PedidoDTO;
import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Situacao;
import br.com.capgemini.visseModas.models.repositories.ItemPedidoRepository;
import br.com.capgemini.visseModas.models.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    //add itens na lista de pedidos
    public List<ItemPedido> adicionarItem(ItemPedido item){

        item.getValorPorItem();

        if(item.getProduto().getStatus() == true){
            item.getPedido().getListaItens().add(item);
            item.getPedido().getValorTotal().add(item.getValorPorItem());
        }

        return item.getPedido().getListaItens();
    }

    //remove itens da lista de pedidos
    public List<ItemPedido> removerItem(ItemPedido item){
        item.getPedido().getValorTotal().subtract(item.getValorPorItem());
        item.getPedido().getListaItens().remove(item);

        return item.getPedido().getListaItens();
    }

    public void salvar(Pedido pedido){
        pedido.setSituacao(Situacao.FECHADO);
        pedidoRepository.save(pedido);
    }

    public ResponseEntity<Pedido> inativar(Long id) {

        Optional<Pedido> optional = pedidoRepository.findById(id);
        if(optional.isPresent()){

            Pedido pedido = optional.get();
            //pedido.setSituacao(Situacao.CANCELADO);
            pedidoRepository.save(pedido);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<PedidoDTO> detalhar(Long id){
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if(pedidoOptional.isPresent()){
            return ResponseEntity.ok(new PedidoDTO(pedidoOptional.get()));
        }

        return ResponseEntity.notFound().build();
    }

    public List<PedidoDTO> listarTudoDTO(){
        List<Pedido> listaPedidos = pedidoRepository.findAll();
        return PedidoDTO.converteListaPedidoParaListaPedidoDTO(listaPedidos);
    }

//    public List<PedidoDTO> listarTudoPersonalizada(){
//        List<Pedido> listaPedidos = itemPedidoRepository.listaItensPersonalizada();
//        return PedidoDTO.converter(listaPedidos);
//    }


    /*public BigDecimal calcularDesconto(Pedido pedido, BigDecimal percentualDesconto){
        if(pedido.getSituacao().equals("ABERTO")) {
            BigDecimal valorFinal = pedido.getValorTotal().multiply(percentualDesconto);
            return valorFinal;
        }
        return (new BigDecimal(0));
    }*/

    public Pedido buscarPorId(Long id) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    public Page<PedidoDTO> listarTudoDTOPaginacao(Pageable paginacao) {
        //devolve um page ao invés de uma lista
        Page<Pedido> listaPedidos = pedidoRepository.findAll(paginacao);
        return PedidoDTO.converteListaPedidoParaListaPedidoDTOPaginacao(listaPedidos);
    }

}