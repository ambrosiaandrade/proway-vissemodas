import { Produto } from './produto.model';

export class ItemPedido {
  id?: number;
  produto: Produto[];
  pedido?: number;
  quantidade: number;
  valorTotal: number;

  constructor(produto: Produto[], quantidade: number, valorTotal: number) {
    this.produto = produto;
    this.quantidade = quantidade;
    this.valorTotal = valorTotal;
  }
}
