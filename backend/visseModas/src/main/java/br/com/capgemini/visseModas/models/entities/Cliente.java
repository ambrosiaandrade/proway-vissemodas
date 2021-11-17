package br.com.capgemini.visseModas.models.entities;

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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nome;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    private String documento;
    private String email;
    private String senha;

    //TODO ver se precisa mais de um endereco
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> listaEnderecos;

    public Cliente(String nome, TipoCliente tipoCliente, String documento, String email, String senha, List<Endereco> listaEnderecos) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.documento = documento;
        this.email = email;
        this.senha = senha;
        this.listaEnderecos = listaEnderecos;
    }

}
