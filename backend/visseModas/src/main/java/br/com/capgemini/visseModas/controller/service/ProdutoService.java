package br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.dtoSaida.ProdutoDTO;
import br.com.capgemini.visseModas.model.entity.Produto;
import br.com.capgemini.visseModas.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    /*  •	Não deve ser possível excluir um produto se ele estiver associado a algum pedido
        •	Não deve ser possível adicionar um produto desativado em um pedido*/


    @Autowired // injeção de dependência
    private ProdutoRepository repository;

    public void salvar(Produto produto){
        repository.save(produto);
    }

    public void deletar(Long id){
        repository.deleteById(id);
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


    public Produto alterar(Long id){
        // Recebe do banco de dados
        Optional<Produto> produtoBuscado = repository.findById(id);

        // Verificação para saber se existe
        if (!produtoBuscado.isPresent()){
            return null;
        }

        // Convertendo o Option
        Produto produto = produtoBuscado.get();
        Produto produtoNovo = new Produto();

        // Settando
        produtoNovo.setDescricao(produto.getDescricao());
        produtoNovo.setTamanho(produto.getTamanho());
        produtoNovo.setValorUnitario(produto.getValorUnitario());
        produtoNovo.setStatus(produto.getStatus());

        // Salvar
        repository.save(produtoNovo);
        return produtoNovo;
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
