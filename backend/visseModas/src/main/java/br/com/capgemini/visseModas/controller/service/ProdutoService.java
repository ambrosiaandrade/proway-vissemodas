package br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.dto.ProdutoDTO;
import br.com.capgemini.visseModas.model.entity.Produto;
import br.com.capgemini.visseModas.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

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

    // find com DTO
    public List<ProdutoDTO> listarTudoDTO(){
        List<Produto> listaProdutos = repository.findAll();
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

}
