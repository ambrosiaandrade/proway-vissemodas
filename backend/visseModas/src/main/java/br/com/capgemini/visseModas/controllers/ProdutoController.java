package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.services.ProdutoService;
import br.com.capgemini.visseModas.models.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping //findAll
    public List<Produto> listarTudo() {
        return service.listarTudo();
    }

    @GetMapping("/{id}") //findAll
    public Produto produto(@PathVariable Long id) {
        return service.buscarUmProduto(id);
    }

    @PostMapping //save   //vai no corpo
    public void salvar(@RequestBody Produto produto) {
        service.salvar(produto);
    }

//    @DeleteMapping("/{id}") //delete
//    public void deletar(@PathVariable Long id) {
//        service.inativar(id);
//    }

    @DeleteMapping("/{id}/{status}") //delete
    public void deletar(@PathVariable Long id, @PathVariable Boolean status) {
        service.ativarInativar(id, status);
    }

    @PutMapping("/{id}") //merge
    public Object alterar(@PathVariable Long id, @RequestBody Produto produto) {

        Produto produtoAlterado = service.alterar(id, produto);

        if (produtoAlterado == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não foi encontrado");
        }

        return HttpStatus.OK;
    }

}


