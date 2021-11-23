package br.com.capgemini.visseModas.repositories;

import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.ProdutoRepository;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private TestEntityManager em;

    @Test
    public void deveriaRetornarSomenteProdutosAtivos(){

        Produto p1 = new Produto();
        p1.setDescricao("Shorts");
        em.persist(p1);

        Produto p2 = new Produto();
        p2.setDescricao("Camiseta");
        p2.setStatus(false);
        em.persist(p2);

        List<Produto> banco = produtoRepository.findByStatus(true);
        List<String> atual = Arrays.asList(p1.getDescricao());
        List<String> listaBanco = new ArrayList<>();


        for (Produto p : banco) {
           listaBanco = Arrays.asList(p.getDescricao());
        }

        //List<String> listaBanco = Arrays.asList(banco.get(0).getDescricao());

        Assertions.assertArrayEquals(atual.toArray(), listaBanco.toArray());

    }

//    @Test
//    public void DeveriaRetonarTodosProdutos(){
//        String nomeCliente = "Maria";
//        Optional optional = clienteRepository.findByNome(nomeCliente);
//
//        Assert.assertFalse(optional.isPresent()); //vê se vem o nome nullo, porque não existe no banco.
//
//    }

}
