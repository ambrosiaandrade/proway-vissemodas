package br.com.capgemini.visseModas.ambrosia.model;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ClientePJ extends Cliente{

    private String cnpj;

    @Override
    public String toString() {
        return "ClientePJ{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
