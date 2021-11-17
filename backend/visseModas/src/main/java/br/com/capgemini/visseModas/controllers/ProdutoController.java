package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.models.dtos.dtos.ProdutoDTO;
import br.com.capgemini.visseModas.models.dtos.form.ProdutoForm;
import br.com.capgemini.visseModas.services.ProdutoService;
import br.com.capgemini.visseModas.models.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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
    public ResponseEntity<ProdutoDTO> alterar(@PathVariable Long id, @RequestBody @Valid ProdutoDTO produtoDTO, UriComponentsBuilder uriBuilder ) {


        Produto produto = produtoDTO.converteDTOParaProduto();
        service.alterar(id, produtoDTO);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDTO(produto));

    }

    //deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return service.inativar(id); //chamar o deletar e decidir no service se deleta ou nao
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



        Produto produtoAlterado = service.alterar(id, produto);

        if (produtoAlterado == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não foi encontrado");
        }

        return HttpStatus.OK;
    }

}


