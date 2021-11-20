package br.com.capgemini.visseModas.controllers;
import br.com.capgemini.visseModas.models.dtos.dtos.PedidoDTO;
import br.com.capgemini.visseModas.models.dtos.form.PedidoForm;
import br.com.capgemini.visseModas.services.ClienteService;
import br.com.capgemini.visseModas.services.EnderecoService;
import br.com.capgemini.visseModas.services.PedidoService;
import br.com.capgemini.visseModas.models.entities.Pedido;
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
    private PedidoService service;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> salvar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder) {

        Pedido pedido = form.formToPedido(clienteService);
        service.salvar(pedido);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover (@PathVariable Long id) {
        return service.inativar(id);
    }

    @GetMapping("{/id}")
    public ResponseEntity<PedidoDTO> detalhar(@PathVariable Long id){
        return service.detalhar(id);
    }

    @GetMapping
    public List<PedidoDTO> listarTudo() {
        return service.listarTudoDTO();
    }

    @GetMapping("pageable")                     //setando uma ordenacao default, se não passar parametros
    public Page<PedidoDTO> listarTudoPaginacao(@PageableDefault(sort="id", direction = Sort.Direction.ASC, page=0, size = 10) Pageable paginacao) {
        return service.listarTudoDTOPaginacao(paginacao);
    }

}