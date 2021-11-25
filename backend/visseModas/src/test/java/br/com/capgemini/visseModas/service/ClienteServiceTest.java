package br.com.capgemini.visseModas.service;

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
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ClienteServiceTest {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TestEntityManager em;

    @Test
    public void deveriaSalvarCliente() {

        Cliente cliente = new Cliente();
        cliente.setNome("Valquiria");

        Cliente c1 = em.persist(cliente);
        Cliente c2 = clienteRepository.save(cliente);

        Assert.assertEquals(cliente, c1);
        Assert.assertEquals(cliente, c2);
    }

    @Test
    public void deveriaRetornarClientePorId() {

        Cliente cliente = new Cliente();
        cliente.setNome("Valquiria");

        Cliente clienteSalvo = em.persist(cliente);

        Cliente c1 = clienteRepository.getById(clienteSalvo.getId());

        Assert.assertEquals(cliente.getNome(), c1.getNome());

    }

    @Test
    public void naoDeveriaRetornarClientePorId() {

        Cliente cliente = new Cliente();
        cliente.setNome("Valquiria");
        Cliente clienteSalvo = em.persist(cliente);
        Long idInvalido = 50l;

        Optional<Cliente> clienteOptional = clienteRepository.findById(idInvalido);
        Assert.assertFalse(clienteOptional.isPresent());

    }


}




