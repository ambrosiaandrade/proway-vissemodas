package br.com.capgemini.visseModas.models.dtos.form;

import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.Endereco;
import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.repositories.ClienteRepository;
import br.com.capgemini.visseModas.models.repositories.EnderecoRepository;
import br.com.capgemini.visseModas.services.ClienteService;
import br.com.capgemini.visseModas.services.EnderecoService;
import lombok.Setter;

import java.util.List;

//DTO entrada de dados da view pro banco
@Setter
public class PedidoForm {

    private String nomeCliente;
    private String cep;
    private List<ItemPedido> itensPedidos;
    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    public PedidoForm(){

    }

    //método que pega os dados do dto e converte para entidade
    public Pedido formToPedido(ClienteService clienteService, EnderecoService enderecoService){

        //Cliente cliente = clienteRepository.findByNome(nomeCliente);
        Cliente cliente = clienteService.buscarPorNome(nomeCliente);
        //Endereco endereco = enderecoRepository.findByCep(cep);
        Endereco endereco = enderecoService.buscarPorCep(cep);


        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setEnderecoEntrega(endereco);
        //pedido.setItensPedidos
        pedido.setValorTotal(valorTotal);
        pedido.setQuantidadeTotal(quantidadeTotal);
        pedido.setPercentualDesconto(percentualDesconto);

        return pedido;
    }
}