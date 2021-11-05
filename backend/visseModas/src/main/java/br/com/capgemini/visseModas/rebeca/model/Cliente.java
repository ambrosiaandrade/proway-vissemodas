package br.com.capgemini.visseModas.rebeca.model;

import java.util.List;

public abstract class Cliente {

    protected Integer id;
    protected String nome;

    protected List<Endereco> listaEnderecos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getListaEnderecos() {
        return listaEnderecos;
    }

    public void setListaEnderecos(List<Endereco> listaEnderecos) {
        this.listaEnderecos = listaEnderecos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", listaEnderecos=" + listaEnderecos +
                '}';
    }
}
