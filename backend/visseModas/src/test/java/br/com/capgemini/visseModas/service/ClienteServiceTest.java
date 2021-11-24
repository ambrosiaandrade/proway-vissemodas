//package br.com.capgemini.visseModas.service;
//
//import br.com.capgemini.visseModas.models.entities.Cliente;
//import br.com.capgemini.visseModas.models.repositories.ClienteRepository;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.persistence.EntityNotFoundException;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
//public class ClienteServiceTest {
//
//    @Autowired
//    private ClienteRepository clienteRepository;
//    @Autowired
//    private TestEntityManager em;
//
//    @Test
//    public void deveriaSalvarCliente() {
//
//        Cliente cliente = new Cliente();
//        cliente.setNome("Valquiria");
//        Cliente clienteSalvo = em.persist(cliente);
//
//        Assert.assertEquals(cliente, clienteSalvo);
//    }
//
//    @Test
//    public void deveriaRetornarClientePorId() {
//
//        Cliente cliente = new Cliente();
//        cliente.setNome("Valquiria");
//        Cliente clienteSalvo = em.persist(cliente);
//
//        Cliente c1 = clienteRepository.getById(clienteSalvo.getId());
//
//        Assert.assertEquals(cliente.getNome(), c1.getNome());
//
//    }
//
//    @Test
//    public void naoDeveriaRetornarClientePorId() {
//
//        Cliente cliente = new Cliente();
//        cliente.setNome("Valquiria");
//        Cliente clienteSalvo = em.persist(cliente);
//        Long idInvalido = 50l;
//
//
//        try {
//            Cliente c1 = clienteRepository.getById(idInvalido);
//            service.calcularBonus(funcionario);
//            Assert.fail("Nao ocorreu a exception!");
//        } catch (IllegalArgumentException e) {}
//
//
//        Assert.assertThrows(EntityNotFoundException.class() -> clienteRepository.getById(idInvalido);
//
//    }
//
//
////    @Test
////        //teste de exception, simulando se uma excessao está acontecendo
////    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
////        BonusService service = new BonusService();
////        assertThrows(IllegalArgumentException.class,
////                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
////
////        try{
////            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
////            fail("Não deu a exception.");
////        }catch (Exception e){
////            assertEquals("Funcionário com salário maior de R$ 10.000, não pode receber bônus.", e.getMessage());
////        }
////
////
////
////    }
//
//
//
//
////    @Test
////    public void deveriaListarTodosClientes(){
////
////    }
//
//
////
////    @Test
////    void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
////        ReajusteService service = new ReajusteService();
////        Funcionario fulano =
////                new Funcionario("Fulano",
////                        LocalDate.now(),
////                        new BigDecimal("2000.00"));
////
////        service.concederReajuste(fulano,
////                Desempenho.OTIMO);
////
////        assertEquals(new BigDecimal("2400.00"),
////                fulano.getSalario());
////    }
//
//
//}
//
//
//
//
