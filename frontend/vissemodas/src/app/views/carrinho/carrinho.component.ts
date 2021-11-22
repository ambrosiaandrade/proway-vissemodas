import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produto } from 'src/app/models/produto.model';
import { ItemPedidoService } from 'src/app/services/item-pedido.service';
import { ListProdutoComponent } from '../produto/list-produto/list-produto.component';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css'],
})
export class CarrinhoComponent implements OnInit {
  // Vem do localStorage
  listItensPedido: Produto[] = [];

  constructor(private _router: Router) {
    // let listarCarrinho = _produto.carrinho
  }

  ngOnInit(): void {
    this.buscarItemPedido();
  }

  buscarItemPedido() {
    if (localStorage.getItem('list')) {
      this.listItensPedido = JSON.parse(localStorage.getItem('list') || '{}');
    } else {
      this.listItensPedido = [];
    }
  }

  removerItemPedido(id: any) {
    // filter() retorna uma lista que satisfaz a condição,
    // neste caso, ser diferente do id passado por parâmetro
    // logo, retorna tudo exceto o que tiver esse id
    this.listItensPedido = this.listItensPedido.filter(
      (item) => item.id !== id
    );

    // Atribuindo essa nova lista filtrada para o localStorage
    localStorage.setItem('list', JSON.stringify(this.listItensPedido));
  }

  finalizarCompra() {
    // TODO: fazer a implementação
    this._router.navigate(['/finalizado']);
  }
}
