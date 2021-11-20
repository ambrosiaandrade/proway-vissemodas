import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/models/produto.model';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-list-produto',
  templateUrl: './list-produto.component.html',
  styleUrls: ['./list-produto.component.css']
})
export class ListProdutoComponent implements OnInit {

  listaProdutos: Produto[] = [];
  carrinho: Produto[] = []

  constructor(private _service: ProdutoService) { }

  ngOnInit(): void {
    this.listarProdutos();
  }

  listarProdutos() {
    return this._service.getProdutos().subscribe({
      next: (data) => {
        //console.log(data);
        this.listaProdutos = data;
      },
      error: (e) => console.log(e)
    });
  }

  addToCart(produto: any){
    this.carrinho.push(produto);
  }

}