package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.dtos.ProdutoDTO;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private ProdutoRepository repository;

    public void salvar(Produto produto){
        repository.save(produto);
    }

    //Não deve ser possível excluir um produto se ele estiver associado a algum pedido
    public void deletar(Long id){
        repository.deleteById(id);
    }

    // O link do post que resolveu um problema
    // https://stackoverflow.com/questions/52656517/no-serializer-found-for-class-org-hibernate-proxy-pojo-bytebuddy-bytebuddyinterc
    public Produto buscarUmProduto(Long id){
        return repository.findById(id).get();
    }

    public List<Produto> listarTudo(){
        return repository.findAll();
    }
//
//    // find com DTO
//    public List<ProdutoDTO> listarTudoDTO(){
//        List<Produto> listaProdutos = repository.findAll();
//        return ProdutoDTO.converter(listaProdutos);
//    }

    // Não deve ser possível adicionar um produto desativado em um pedido
    public List<ProdutoDTO> listarTudoAtivo(){
        List<Produto> listaProdutos = repository.findByStatus(true);
        return ProdutoDTO.converter(listaProdutos);
    }

    public Produto alterar(Long id, Produto produto){

        try{
            // Verificar se existe
            Optional<Produto> temProduto = repository.findById(id);

            // Recebe do banco de dados
            Produto produtoBuscado = repository.findById(id).get();

            // Settando
            produtoBuscado.setDescricao(produto.getDescricao());
            produtoBuscado.setTamanho(produto.getTamanho());
            produtoBuscado.setValorUnitario(produto.getValorUnitario());
            produtoBuscado.setStatus(produto.getStatus());

            repository.save(produtoBuscado);
            return produtoBuscado;

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }

    }

//    public void inativar(Long id) {
//        Produto produtoExcluir = repository.getById(id);
//        produtoExcluir.setStatus(false);
//        repository.save(produtoExcluir);
//    }
//
    public void ativarInativar(Long id, Boolean status) {
        Produto produtoExcluir = repository.getById(id);
        // Se veio como verdadeiro é settado como falso...
        produtoExcluir.setStatus(!status);

        repository.save(produtoExcluir);
    }



}
