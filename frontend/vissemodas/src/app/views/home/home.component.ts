import { Component, OnInit } from '@angular/core';
import { ProdutoService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/models/produto.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  listProdutos: Produto[] = [];

  constructor(private _service: ProdutoService) {}

  ngOnInit(): void {
    this.buscarProduto();
  } 

  buscarProduto() {
    this._service.getProdutos().subscribe({
      next: (data) => {
        this.listProdutos = data;
        console.log(data);
      },
      error: (e) => console.log(e),
    });
  }

}
