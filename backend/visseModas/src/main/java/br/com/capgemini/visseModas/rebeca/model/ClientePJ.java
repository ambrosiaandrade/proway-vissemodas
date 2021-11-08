package br.com.capgemini.visseModas.rebeca.model;

public class ClientePJ extends Cliente {

    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "ClientePJ{" +
                "id=" + id +
                ", nome=" + nome + '\'' +
                "cnpj='" + cnpj + '\'' +
                '}';
    }
}
