import { Produto } from './produto.model';

export class ItemPedido {
  id?: number;
  produto: Produto;
  pedido?: number;
  quantidade: number;
  valorPorItem: number;

  constructor(produto: Produto, quantidade: number, valorPorItem: number) {
    this.produto = produto;
    this.quantidade = quantidade;
    this.valorPorItem = valorPorItem;
  }
}
