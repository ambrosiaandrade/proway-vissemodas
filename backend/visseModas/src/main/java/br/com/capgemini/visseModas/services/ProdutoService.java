package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.dtos.ClienteDTO;
import br.com.capgemini.visseModas.models.dtos.dtos.ProdutoDTO;
import br.com.capgemini.visseModas.models.dtos.update.ClienteUpdate;
import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProdutoService {

    // Não deve ser possível excluir um produto se ele estiver associado a algum pedido

    @Autowired // injeção de dependência
    private ProdutoRepository produtoRepository;

    public void salvar(Produto produto){
        produtoRepository.save(produto);
    }

    public ResponseEntity<ProdutoDTO> alterar(Long id, ProdutoDTO produtoDTO) {

        Optional<Produto> optional =  produtoRepository.findById(id);
        if (optional.isPresent()) {
            Produto produto = produtoDTO.atualizar(id, produtoRepository);
            produtoRepository.save(produto);
            return ResponseEntity.ok(new ProdutoDTO(produto));
        }

        return ResponseEntity.notFound().build();
    }

    //Não deve ser possível excluir um produto se ele estiver associado a algum pedido
    public ResponseEntity<Produto> inativar(Long id) {

        Optional<Produto> optional = produtoRepository.findById(id);

        if (optional.isPresent()) {

            Produto produto = optional.get();
            produto.setStatus(false);
            produtoRepository.save(produto);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();
    }


    public ResponseEntity<ProdutoDTO> detalhar(Long id) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new ProdutoDTO(optional.get()));
        }

        return ResponseEntity.notFound().build();
    }

    public List<ProdutoDTO> listarTudo(){
        List<Produto> listaProdutos = produtoRepository.findAll();
        return ProdutoDTO.converter(listaProdutos);
    }

    // Não deve ser possível adicionar um produto desativado em um pedido
    public List<ProdutoDTO> listarTudoAtivo(){
        List<Produto> listaProdutos = produtoRepository.findByStatus(true);
        return ProdutoDTO.converter(listaProdutos);
    }



//    public Produto alterar(Long id){
//        // Recebe do banco de dados
//        Optional<Produto> produtoBuscado = produtoRepository.findById(id);
//
//        // Verificação para saber se existe
//        if (!produtoBuscado.isPresent()){
//            return null;
//        }
//
//        // Convertendo o Option
//        Produto produto = produtoBuscado.get();
//        Produto produtoNovo = new Produto();
//
//        // Settando
//        produtoNovo.setDescricao(produto.getDescricao());
//        produtoNovo.setTamanho(produto.getTamanho());
//        produtoNovo.setValorUnitario(produto.getValorUnitario());
//        produtoNovo.setStatus(produto.getStatus());
//
//        // Salvar
//        produtoRepository.save(produtoNovo);
//        return produtoNovo;
//    }




}
