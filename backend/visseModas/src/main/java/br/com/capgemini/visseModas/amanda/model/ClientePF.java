package br.com.capgemini.visseModas.amanda.model;

public class ClientePF extends Cliente {
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ClientePF{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
