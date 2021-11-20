import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ListProdutoComponent } from '../produto/list-produto/list-produto.component';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css'],
})
export class CarrinhoComponent implements OnInit {
  constructor(private _router: Router) {
  // let listarCarrinho = _produto.carrinho

  }
  
  ngOnInit(): void {}

  finalizarCompra() {
    // TODO: fazer a implementação
    this._router.navigate(['/finalizado']);
  }
}
