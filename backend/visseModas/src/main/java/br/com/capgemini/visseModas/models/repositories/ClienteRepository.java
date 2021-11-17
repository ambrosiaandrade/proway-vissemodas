package br.com.capgemini.visseModas.models.repositories;

import br.com.capgemini.visseModas.models.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //buscando o cliente por nome
    Optional<Cliente> findByNome(String nome);

    //buscando com joins, RelacionamentoAtributo(no topico tenho um atributo curso do tipo curso e filtro pelo nome do curso)
    //List<Topico> findByCursoNome(String nomeCurso);

}
