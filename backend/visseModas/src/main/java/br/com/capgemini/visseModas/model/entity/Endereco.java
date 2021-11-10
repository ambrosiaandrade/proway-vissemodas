package main.java.br.com.capgemini.visseModas.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import br.com.capgemini.visseModas.model.entity.Cliente;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    //lado mais forte é a tabela que tem que a coluna do relacionamento



}
