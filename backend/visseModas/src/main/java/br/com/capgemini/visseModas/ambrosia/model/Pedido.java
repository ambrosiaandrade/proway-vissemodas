package br.com.capgemini.visseModas.ambrosia.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Endereco endereco;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItensPedido> itensPedidos = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", data=" + data +
                ", cliente=" + cliente +
                ", endereco=" + endereco +
                ", situacao=" + situacao +
                ", valorTotal=" + valorTotal +
                ", quantidadeTotal=" + quantidadeTotal +
                ", percentualDesconto=" + percentualDesconto +
                '}';
    }
}
