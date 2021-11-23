package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.dtos.ProdutoDTO;
import br.com.capgemini.visseModas.models.dtos.update.ProdutoUpdate;
import br.com.capgemini.visseModas.models.entities.Endereco;
import br.com.capgemini.visseModas.models.entities.ItemPedido;
import br.com.capgemini.visseModas.models.entities.Pedido;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ItemPedidoRepository;
import br.com.capgemini.visseModas.models.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public void salvar(Produto produto){
        produtoRepository.save(produto);
    }

    public Produto alterar(Long id, ProdutoUpdate form) {

        Optional<Produto> optional =  produtoRepository.findById(id);
        if (optional.isPresent()) {

            Produto produto = form.atualizar(id, produtoRepository);
            produtoRepository.save(produto);
            return produto;
        }
        return null;
    }

    //TODO Não deve ser possível excluir um produto se ele estiver associado a algum pedido
    public ResponseEntity<Produto> deletar(Long idProduto) {

        //busca o produto pelo id
        Optional<Produto> optional = produtoRepository.findById(idProduto);
        Produto produto = optional.get();

        //verifica se o produto está vinculado a algum item
        List<ItemPedido> lista = itemPedidoRepository.findByProdutoId(idProduto);

        //se não tiver vínculo a lista volta vazia e pode exluir o produto
        if(lista.isEmpty()){
            produtoRepository.delete(produto);
            return ResponseEntity.ok().build();
        }

        //se a lista não tiver vazia, não pode excluir portanto o produto será inativado
        inativar(produto);
        return ResponseEntity.badRequest().build();
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


    public Produto buscarPorId(Long id) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    //metodo para inativar produto
    public void inativar(Produto produto){
        produto.setStatus(false);
        produtoRepository.save(produto);
    }

    public Page<ProdutoDTO> listarTudoDTOPaginacao(Pageable paginacao) {
        //devolve um page ao invés de uma lista
        Page<Produto> listaProdutos = produtoRepository.findAll(paginacao);
        return ProdutoDTO.converterPaginacao(listaProdutos);
    }


}
