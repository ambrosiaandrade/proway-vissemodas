package br.com.capgemini.visseModas.models.repositories;

import br.com.capgemini.visseModas.models.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //buscando o cliente por nome
    Cliente findByNome(String nome);

    //buscando com joins, RelacionamentoAtributo(no topico tenho um atributo curso do tipo curso e filtro pelo nome do curso)
    //List<Topico> findByCursoNome(String nomeCurso);

}
