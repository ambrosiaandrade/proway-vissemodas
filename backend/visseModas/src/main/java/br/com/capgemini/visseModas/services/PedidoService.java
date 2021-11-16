package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.dtos.PedidoDTO;
import br.com.capgemini.visseModas.models.dtos.update.PedidoUpdate;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Situacao;
import br.com.capgemini.visseModas.models.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    // TODO	Não deve ser possível adicionar um produto desativado em um pedido*/

    @Autowired //injecao de dependencia para que o service se comunique com o repository
    private PedidoRepository pedidoRepository;

    public void salvar(Pedido pedido){
        pedidoRepository.save(pedido);
    }

    public ResponseEntity<PedidoUpdate> alterar(Long id, PedidoUpdate form){

        Optional<Pedido> optional = pedidoRepository.findById(id);
        if(optional.isPresent()){
           Pedido pedido = form.atualizar(id, pedidoRepository);
           pedidoRepository.save(pedido);
           return ResponseEntity.ok(new PedidoUpdate(pedido));
        }
        // converte o option

        return ResponseEntity.notFound().build();
    }

    /*public void deletar(Long id){
        pedidoRepository.deleteById(id);
    }*/

    public ResponseEntity<Pedido> inativar(Long id) {

        Optional<Pedido> optional = pedidoRepository.findById(id);
        if(optional.isPresent()){

            Pedido pedido = optional.get();
            pedido.setSituacao(Situacao.CANCELADO);
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

    // find com DTO
    public List<PedidoDTO> listarTudoDTO(){
        List<Pedido> listaPedidos = pedidoRepository.findAll();
        return PedidoDTO.converter(listaPedidos);
    }

    //Deverá ser possível aplicar um percentual de desconto no pedido. O desconto será sobre o valor total dos produtos
    // Somente será possível aplicar desconto no pedido se ele estiver na situação Aberto (Fechado bloqueia)*/
    //                                     500                  30
    public Double calcularDesconto(Pedido pedido, Double percentualDesconto){

        if(pedido.getSituacao().equals("ABERTO")) {
            //                           500 -        500              30          / 100
            Double valorFinal = pedido.getValorTotal() - (pedido.getValorTotal() * (percentualDesconto / 100));
            return valorFinal;
        }
        return 0.0;
    }

}