package br.com.capgemini.visseModas.repositories;

import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.repositories.ClienteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest //anotacao para testar respositories fornecida pelo Spring
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //não substitua meu banco pra usar o banco em memoria.
@ActiveProfiles("test") //setar outro ambiente, e chamar o propierties-test
public class ClienteRepositoryTest {

    @Autowired //injecao de dependecias fornecida pelo Spring
    private ClienteRepository clienteRepository;
    @Autowired
    private TestEntityManager em;

    @Test
    public void deveriaRetornarClientePorNome(){

        String nomeCliente = "Val";

        //como o banco está vazio, sempre vai ter que popular pra testar
        Cliente c1 = new Cliente();
        c1.setNome("Val");
        em.persist(c1);

        Cliente cliente = clienteRepository.findByNome(nomeCliente).get();
        Assert.assertNotNull(nomeCliente); //vê se não vem o nome nullo, porque existe esse no banco.
        Assert.assertEquals(nomeCliente, cliente.getNome()); //vê se tem no banco.

    }

    @Test
    public void DeveriaRetonarClienteNullo(){
        String nomeCliente = "Maria";
        Optional optional = clienteRepository.findByNome(nomeCliente);

        Assert.assertFalse(optional.isPresent()); //vê se vem o nome nullo, porque não existe no banco.

    }

}
