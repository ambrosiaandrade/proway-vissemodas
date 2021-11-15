package br.com.capgemini.visseModas.controller;

import br.com.capgemini.visseModas.controller.service.ProdutoService;
import br.com.capgemini.visseModas.model.dtoSaida.ProdutoDTO;
import br.com.capgemini.visseModas.model.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping //findAll
    public List<Produto> listarTudo() {
        return service.listarTudo();
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

    @PatchMapping("/{id}") //merge
    public Produto alterar(@PathVariable Long id, @RequestBody Produto produto) {

        Produto produtoAlterado = service.alterar(id);
        return produtoAlterado;

    }





}


