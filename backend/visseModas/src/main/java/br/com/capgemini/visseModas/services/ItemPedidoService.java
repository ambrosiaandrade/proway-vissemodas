package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.dtos.ItemPedidoDTO;
import br.com.capgemini.visseModas.models.dtos.dtos.PedidoDTO;
import br.com.capgemini.visseModas.models.dtos.update.ItemPedidoUpdate;
import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.repositories.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public void salvar(ItemPedido itemPedido){
        itemPedidoRepository.save(itemPedido);
    }

    public ResponseEntity<ItemPedidoUpdate> alterar(Long id, ItemPedidoUpdate form){

        Optional<ItemPedido> optional = itemPedidoRepository.findById(id);

        if(!optional.isPresent()){
            ItemPedido itemPedido = form.atualizar(id,itemPedidoRepository);
            itemPedidoRepository.save(itemPedido);
            return ResponseEntity.ok(new ItemPedidoUpdate(itemPedido));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ItemPedidoDTO> detalhar(Long id){
        Optional<ItemPedido> itemPedidoOptional = itemPedidoRepository.findById(id);
        if(itemPedidoOptional.isPresent()){
            return ResponseEntity.ok(new ItemPedidoDTO(itemPedidoOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }



    /*public void deletar(Long id){
        itemPedidoRepository.deleteById(id);
    }*/
    /*public List<ItemPedido> listarTudo(){
        return itemPedidoRepository.findAll();
    }*/

    // find com DTO
    public List<ItemPedidoDTO> listarTudoDTO(){
        List<ItemPedido> listaItemPedido = itemPedidoRepository.findAll();
        return ItemPedidoDTO.converter(listaItemPedido);
    }

    public ResponseEntity<?> inativar(Long id) {
        return null;
    }

    /*public ItemPedido alterar(Long id, @Valid ItemPedidoUpdate form){

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
    }*/

}