import { Injectable } from '@angular/core';
import { Produto } from '../models/produto.model';

@Injectable({
  providedIn: 'root',
})
export class ItemPedidoService {
  listProdutos: Produto[] = [];

  constructor() {}

  testingItemPedido() {
    console.log('testing ItemPedido');
  }

  addToItemPedido(produto: Produto) {
    this.listProdutos.push(produto);
    // testando se grava no arquivo
    this.storeInLocalStorage();
  }

  getItemPedidoList(): Produto[] {
    console.log('item-pedido.service', this.listProdutos);
    return this.listProdutos;
  }

  storeInLocalStorage(): void {
    localStorage.setItem('list', JSON.stringify(this.listProdutos));
  }

  getFromLocalStorage(): any {
    if (localStorage.getItem('list')) {
      return JSON.parse(localStorage.getItem('list') || '{}');
    } else {
      return [];
    }
  }
}
