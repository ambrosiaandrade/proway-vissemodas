package br.com.capgemini.visseModas.models.repositories;

import br.com.capgemini.visseModas.models.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>  {

    //@Query("select p from pedido p where p.situacao = :situacao")
    //List<Pedido> findBySituacao(@Param("situacao") Situacao situacao);


//    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome "
//            + "AND f.salario >= :salario AND f.dataContratacao = :data")
//    List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);
//
//    @Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data",
//            nativeQuery = true)
//    List<Funcionario> findDataContratacaoMaior(LocalDate data);
//



}
