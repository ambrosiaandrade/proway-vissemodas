package br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.dtoSaida.ItemPedidoDTO;
import br.com.capgemini.visseModas.model.entity.ItemPedido;
import br.com.capgemini.visseModas.model.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository repository;

    public void salvar(ItemPedido itemPedido){
        repository.save(itemPedido);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
    public List<ItemPedido> listarTudo(){
        return repository.findAll();
    }

    // find com DTO
    public List<ItemPedidoDTO> listarTudoDTO(){
        List<ItemPedido> listaItemPedido = repository.findAll();
        return ItemPedidoDTO.converter(listaItemPedido);
    }

    public ItemPedido alterar(Long id){

        // recebe do banco de dados
        Optional<ItemPedido> itemPedidoBuscada = repository.findById(id);

        //verificando se existe
        if(!itemPedidoBuscada.isPresent()){
            return null;
        }
        // converte o Optional
        ItemPedido itemPedido = itemPedidoBuscada.get();

        // criando novo objeto
        ItemPedido itemPedidoNovo = new ItemPedido();

        // setando
        itemPedidoNovo.setProduto(itemPedido.getProduto());
        itemPedidoNovo.setQuantidade(itemPedido.getQuantidade());
        itemPedidoNovo.setValorTotal(itemPedido.getValorTotal());
        repository.save(itemPedido);
        return itemPedido;
    }
}
