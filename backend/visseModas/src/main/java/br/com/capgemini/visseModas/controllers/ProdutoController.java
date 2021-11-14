package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.services.ProdutoService;
import br.com.capgemini.visseModas.models.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

//    @GetMapping //findAll
//    public List<ClienteDTOSaida> listarTudo() {
//        //return service.listarTudoDTO();
//    }

    @PostMapping //save   //vai no corpo
    public void salvar(@RequestBody Produto produto) {
        service.salvar(produto);
    }

    @DeleteMapping("/{id}") //delete
    public void deletar(@PathVariable Long id) {
        service.inativar(id);
    }

    @PatchMapping("/{id}") //merge
    public Produto alterar(@PathVariable Long id, @RequestBody Produto produto) {

        Produto produtoAlterado = service.alterar(id);
        return produtoAlterado;

    }





}


