package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.dtos.PedidoDTOSaida;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Situacao;
import br.com.capgemini.visseModas.models.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    // TODO	Não deve ser possível adicionar um produto desativado em um pedido*/

    @Autowired //injecao de dependencia para que o service se comunique com o repository
    private PedidoRepository repository;

    public void salvar(Pedido pedido){
        repository.save(pedido);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public void inativar(Long id) {
        Pedido pedidoExcluir = repository.getById(id);
        pedidoExcluir.setSituacao(Situacao.CANCELADO);
        repository.save(pedidoExcluir);
    }

    // find com DTO
    public List<PedidoDTOSaida> listarTudoDTO(){
        List<Pedido> listaPedidos = repository.findAll();
        return PedidoDTOSaida.converter(listaPedidos);
    }

    public Pedido alterar(Long id){

        // recebe do banco de dados
        Optional<Pedido> pedidoBuscado = repository.findById(id);

        if(!pedidoBuscado.isPresent()){
            return null;
        }
        // converte o option
        Pedido pedido = pedidoBuscado.get();

        Pedido pedidoNovo = new Pedido();
        pedido.setCliente(pedido.getCliente());
        pedido.setEnderecoEntrega(pedido.getEnderecoEntrega());
        pedido.setItensPedidos(pedido.getItensPedidos());
        pedido.setSituacao(pedido.getSituacao());
        pedido.setValorTotal(pedido.getValorTotal());
        pedido.setQuantidadeTotal(pedido.getQuantidadeTotal());
        pedido.setPercentualDesconto(pedido.getPercentualDesconto());

       repository.save(pedido);

       return pedidoNovo;

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
