import { ItemPedido } from './itemPedido.model';

export class Pedido {
  id?: number;
  data?: Date;
  idCliente: number | undefined;
  idEndereco: number | undefined;
  listaItens: ItemPedido[];
  situacao: string;
  valorTotal: number;
  quantidadeTotal: number;
  percentualDesconto: number;
  nomeCliente?: string;

  constructor(
    idCliente: number,
    idEndereco: number,
    itensPedido: ItemPedido[],
    situacao: string,
    valorTotal: number,
    quantidadeTotal: number,
    percentualDesconto: number
  ) {
    this.idCliente = idCliente;
    this.idEndereco = idEndereco;
    this.listaItens = itensPedido;
    this.situacao = situacao;
    this.valorTotal = valorTotal;
    this.quantidadeTotal = quantidadeTotal;
    this.percentualDesconto = percentualDesconto;
  }
}

/*
    private Long id;
    private LocalDate data = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> listaItens = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.ABERTO;

    private BigDecimal valorTotal = BigDecimal.ZERO;
    private Integer quantidadeTotal;
    private Double percentualDesconto;
*/
