package br.com.capgemini.visseModas.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nome;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;
    private String documento;
    private Boolean status = true;
    private String email;
    private String senha;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    protected List<Endereco> listaEnderecos;


}
