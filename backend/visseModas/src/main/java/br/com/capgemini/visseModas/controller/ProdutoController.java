package br.com.capgemini.visseModas.controller;

import br.com.capgemini.visseModas.controller.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

        @Autowired
        private ProdutoService service;

        @DeleteMapping("/{id}")
        public void inativar(@PathVariable Long id) {
            service.inativar(id);
        }
    }


