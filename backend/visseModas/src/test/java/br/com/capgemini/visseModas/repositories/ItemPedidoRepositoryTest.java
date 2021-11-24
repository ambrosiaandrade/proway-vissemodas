package br.com.capgemini.visseModas.repositories;

import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ItemPedidoRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemPedidoRepositoryTest {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private TestEntityManager em;

//    @Test
//    public void deveriaRetornarSomenteProdutosAtivos(){
//
//        Produto p1 = new Produto();
//        p1.setDescricao("Shorts");
//        em.persist(p1);
//
//        Produto p2 = new Produto();
//        p2.setDescricao("Camiseta");
//        p2.setStatus(false);
//        em.persist(p2);
//
//        List<Produto> banco = produtoRepository.findByStatus(true);
//        List<String> atual = Arrays.asList(p1.getDescricao());
//        List<String> listaBanco = new ArrayList<>();
//
//        for (Produto p : banco) {
//            listaBanco = Arrays.asList(p.getDescricao());
//        }
//
//        Assertions.assertArrayEquals(atual.toArray(), listaBanco.toArray());
//    }
//
//    @Test
//    public void deveriaRetornarTodosOsProdutos(){
//
//        Produto p1 = new Produto();
//        p1.setDescricao("Shorts");
//        em.persist(p1);
//
//        Produto p2 = new Produto();
//        p2.setDescricao("Camiseta");
//        p2.setStatus(false);
//        em.persist(p2);
//
//        List<Produto> banco = produtoRepository.findAll();
//
//        List<String> atual = Arrays.asList(p1.getDescricao(), p2.getDescricao());
//        List<String> listaBanco = new ArrayList<>(banco.size());
//
//        for (Produto p : banco) {
//            listaBanco.add(p.getDescricao());
//        }
//
//        Assertions.assertArrayEquals(atual.toArray(), listaBanco.toArray());
//    }
//
//



}







//    @Test
//    public void DeveriaRetonarTodosProdutos(){
//        String nomeCliente = "Maria";
//        Optional optional = clienteRepository.findByNome(nomeCliente);
//
//        Assert.assertFalse(optional.isPresent()); //vê se vem o nome nullo, porque não existe no banco.
//
//    }
