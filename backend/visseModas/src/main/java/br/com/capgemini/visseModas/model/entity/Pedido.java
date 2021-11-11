package br.com.capgemini.visseModas.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private LocalDate data = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Endereco enderecoEntrega;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedidos = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double percentualDesconto;



}
