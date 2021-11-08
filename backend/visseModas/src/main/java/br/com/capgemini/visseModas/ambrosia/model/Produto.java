package br.com.capgemini.visseModas.ambrosia.model;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
//@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String tamanho;
    //@Column(name = "valor_unitario")
    private Double valorUnitario;
    private Boolean status;

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", status=" + status +
                '}';
    }
}
