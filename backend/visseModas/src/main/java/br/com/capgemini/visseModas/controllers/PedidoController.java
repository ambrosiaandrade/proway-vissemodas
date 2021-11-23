package br.com.capgemini.visseModas.controllers;
import br.com.capgemini.visseModas.models.dtos.response.PedidoDTO;
import br.com.capgemini.visseModas.models.dtos.request_form.PedidoForm;
import br.com.capgemini.visseModas.models.repositories.ItemPedidoRepository;
import br.com.capgemini.visseModas.services.ClienteService;
import br.com.capgemini.visseModas.services.PedidoService;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

//    @PostMapping("/addItem")
//    public ResponseEntity<PedidoDTO> addItem(@RequestBody @Valid ItemPedidoForm itemPedidoForm, UriComponentsBuilder uriBuilder) {
//
//        ItemPedido itemPedido = itemPedidoForm.formToItemPedido(produtoService, pedidoService);
//        pedidoService.adicionarItem(itemPedido);
//
//        Pedido pedido = pedidoService.buscarPorId(itemPedido.getPedido().getId());
//
//        URI uri = uriBuilder.path("/addItem").buildAndExpand(pedido.getId()).toUri();
//        return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
//    }

    @PostMapping
    public ResponseEntity<PedidoDTO> salvar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder) {

        Pedido pedido = form.convertePedidoFormParaPedido(clienteService, produtoService, pedidoService);
        pedidoService.salvar(pedido);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover (@PathVariable Long id) {
        return pedidoService.inativar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> detalhar(@PathVariable Long id) {
        return pedidoService.detalhar(id);
    }

    @GetMapping
    public List<PedidoDTO> listarTudo() {
        return pedidoService.listarTudoDTO();
    }

    @GetMapping("pageable")
    public Page<PedidoDTO> listarTudoPaginacao(@PageableDefault(sort="data", direction = Sort.Direction.ASC, page=0, size = 8) Pageable paginacao) {
        return pedidoService.listarTudoDTOPaginacao(paginacao);
    }

}