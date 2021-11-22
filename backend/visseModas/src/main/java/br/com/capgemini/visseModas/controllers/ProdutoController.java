package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.models.dtos.dtos.ProdutoDTO;
import br.com.capgemini.visseModas.models.dtos.form.ProdutoForm;
import br.com.capgemini.visseModas.models.dtos.update.ProdutoUpdate;
import br.com.capgemini.visseModas.services.ProdutoService;
import br.com.capgemini.visseModas.models.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {

        Produto produto = form.converteFormParaProduto();
        service.salvar(produto);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoDTO> alterar(@PathVariable Long id, @RequestBody @Valid ProdutoUpdate form, UriComponentsBuilder uriBuilder ) {

        Produto produto = form.produtoUpdateToProduto();
        produto.setId(id);
        service.alterar(id, form);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDTO(produto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id, UriComponentsBuilder uriBuilder) {

        ResponseEntity resposta = service.deletar(id); //chamar o deletar e decidir no service se deleta ou nao
        HttpStatus status = resposta.getStatusCode();

        if(status == HttpStatus.BAD_REQUEST){

            Produto produto = service.buscarPorId(id);

            URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
            return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
        }

        return ResponseEntity.ok().build();
    }

    //buscar cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> detalhar(@PathVariable Long id) {
        return service.detalhar(id);
    }

    //listar tudo
    @GetMapping
    public List<ProdutoDTO> listarTudoAtivo() {
        return service.listarTudoAtivo();
    }

    @GetMapping("todos")
    public List<ProdutoDTO> listarTudo() {
        return service.listarTudo();
    }

    @GetMapping("pageable")
    public Page<ProdutoDTO> listarTudoPaginacao(@PageableDefault(sort="descricao", direction = Sort.Direction.ASC, page=0, size = 8) Pageable paginacao) {
        return service.listarTudoDTOPaginacao(paginacao);
    }

}


