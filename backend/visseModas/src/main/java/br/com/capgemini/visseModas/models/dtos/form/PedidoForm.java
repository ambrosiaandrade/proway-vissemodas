package br.com.capgemini.visseModas.models.dtos.form;

import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.Endereco;
import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.services.ClienteService;
import br.com.capgemini.visseModas.services.EnderecoService;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

//DTO entrada de dados da view pro banco
@Setter
public class PedidoForm {

    @NotBlank(message = "O nome do cliente que está fazendo esse pedido é obrigatório")
    private String nomeCliente;
    private List<ItemPedido> itensPedidos;
    private BigDecimal valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    public PedidoForm(){

    }

    //método que pega os dados do dto e converte para entidade
    public Pedido formToPedido(ClienteService clienteService){

        Cliente cliente = clienteService.buscarPorNome(nomeCliente);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        //pedido.setItensPedidos
        pedido.setValorTotal(valorTotal);
        pedido.setQuantidadeTotal(quantidadeTotal);
        pedido.setPercentualDesconto(percentualDesconto);

        return pedido;
    }
}