package br.com.capgemini.visseModas.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    private String cpf;
    private String cnpj;

    @OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Endereco endereco;

    public Cliente(String nome, TipoCliente tipoCliente, String cpf, String cnpj, String email, String senha, Endereco endereco) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

}
