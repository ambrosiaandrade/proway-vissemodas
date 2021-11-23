import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemPedido } from 'src/app/models/itemPedido.model';
import { Produto } from 'src/app/models/produto.model';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css'],
})
export class CarrinhoComponent implements OnInit {
  // Vem do localStorage
  listProdutos: Produto[] = [];

  // Preparação.
  // Cada produto tem um ItemPedido, pois,
  // no ItemPedido vamos ter a quantidade
  // que multiplicamos pelo valorPorItem
  // para 'fecharmos' o pedido
  itemPedido: ItemPedido = {
    produto: {
      descricao: '',
      tamanho: '',
      valorUnitario: 0,
      status: true,
      imagem: '',
      categoria: '',
    },
    quantidade: 0,
    valorPorItem: 0,
  };

  // De fato a nossa lista de itens
  itensPedido: ItemPedido[] = [];

  constructor(private _router: Router, private _toastr: ToastrService) {}

  ngOnInit(): void {
    this.buscarItemPedido();
  }

  buscarItemPedido() {
    if (localStorage.getItem('itensPedido')) {
      this.itensPedido = JSON.parse(
        localStorage.getItem('itensPedido') || '{}'
      );

      // Atribuindo ao itensPedido o produto
      for (let i = 0; i < this.listProdutos.length; i++) {
        let currentProduto = this.listProdutos[i];
        this.itemPedido.produto = currentProduto;
        this.itemPedido.quantidade = 1;
        this.itemPedido.valorPorItem = currentProduto.valorUnitario;

        this.itensPedido.push(this.itemPedido);
      }

      console.log(this.itensPedido);
    } else {
      this.listProdutos = [];
    }
  }

  removerItemPedido(id: any) {
    // filter() retorna uma lista que satisfaz a condição,
    // neste caso, ser diferente do id passado por parâmetro.
    // Logo, retorna tudo exceto o que tiver esse id
    this.itensPedido = this.itensPedido.filter(
      (item) => item.produto.id !== id
    );

    // Retornando uma mensagem ao usuário
    this._toastr.error('Removido do carrinho', 'Produto');

    // Atribuindo essa nova lista filtrada para o localStorage
    localStorage.setItem('itensPedido', JSON.stringify(this.itensPedido));
  }

  handleChangeQTD(qtd: string, id: any) {
    for (let i = 0; i < this.itensPedido.length; i++) {
      if (this.itensPedido[i].produto.id == id) {
        this.itensPedido[i].quantidade = parseInt(qtd);
      }
    }

    // Atribuindo a lista com a QTD alterada para o localStorage
    localStorage.setItem('itensPedido', JSON.stringify(this.itensPedido));
  }

  finalizarCompra() {
    // TODO: fazer a implementação
    this._router.navigate(['/finalizado']);
  }
}
