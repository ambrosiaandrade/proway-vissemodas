package br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.dtoSaida.PedidoDTO;
import br.com.capgemini.visseModas.model.entity.Pedido;
import br.com.capgemini.visseModas.model.entity.Produto;
import br.com.capgemini.visseModas.model.entity.Situacao;
import br.com.capgemini.visseModas.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    // Deverá ser possível aplicar um percentual de desconto no pedido. O desconto será sobre o valor total dos produtos
    // Somente será possível aplicar desconto no pedido se ele estiver na situação Aberto (Fechado bloqueia)

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

    public List<Pedido> listarTudo(){
        return repository.findAll();
    }

    // find com DTO
    public List<PedidoDTO> listarTudoDTO(){
        List<Pedido> listaPedidos = repository.findAll();
        return PedidoDTO.converter(listaPedidos);
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

}
