import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/models/produto.model';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-list-produto',
  templateUrl: './list-produto.component.html',
  styleUrls: ['./list-produto.component.css'],
})
export class ListProdutoComponent implements OnInit {
  listaProdutos: Produto[] = [];
  carrinho: Produto[] = [];

  ultimoIdProduto: number = 0;

  constructor(private _service: ProdutoService) {}

  ngOnInit(): void {
    this.listarProdutos();
  }

  listarProdutos() {
    return this._service.getProdutos().subscribe({
      next: (data) => {
        //console.log(data);
        this.listaProdutos = data;
        this.setUltimoIdProduto();
      },
      error: (e) => console.log(e),
    });
  }

  addToCart(produto: Produto) {
    // this.carrinho.push(produto);
    // console.log(this.carrinho);
    //this._serviceItemPedido.addToItemPedido(produto);
    this.carrinho.push(produto);
    localStorage.setItem('list', JSON.stringify(this.carrinho));
  }

  // Atribuindo o id do último produto
  setUltimoIdProduto() {
    this.ultimoIdProduto = this.listaProdutos.length;
    // console.log('Id último produto');
    // console.log(this.ultimoIdProduto);
  }
}
