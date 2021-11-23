import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemPedido } from 'src/app/models/itemPedido.model';
import { Produto } from 'src/app/models/produto.model';
import { ToastrService } from 'ngx-toastr';
import { Pedido } from 'src/app/models/pedido.model';

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

  count_qtdTotal: number = 0;
  count_valorTotal: number = 0;
  count_desconto: number = 0;

  // Moldando o pedido para enviar para o backend
  pedido: Pedido = {
    idCliente: 0,
    idEndereco: 0,
    itensPedido: [],
    situacao: '',
    valorTotal: 0,
    quantidadeTotal: 0,
    percentualDesconto: 0,
  };

  constructor(private _router: Router, private _toastr: ToastrService) {}

  ngOnInit(): void {
    this.buscarItemPedido();
    this.cleanCount();
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

      this.setCountValues();

      console.log('itensPedido', this.itensPedido);
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

    this.cleanCount();

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

  setCountValues() {
    for (let i = 0; i < this.itensPedido.length; i++) {
      let currentItem = this.itensPedido[i];
      this.count_valorTotal +=
        currentItem.quantidade * currentItem.valorPorItem;
      this.count_qtdTotal += currentItem.quantidade;
    }

    // Desconto de 20% se a compra for maior ou igual a 500 reais
    if (this.count_valorTotal >= 500) {
      this.count_desconto = 0.2;
    }
  }

  cleanCount() {
    this.count_qtdTotal = 0;
    this.count_valorTotal = 0;
    this.count_desconto = 0;
  }

  finalizarCompra() {
    this.setCountValues();

    // todo: quem é o idCliente?
    // todo: qual o idEndereco do cliente?

    this.pedido.itensPedido = this.itensPedido;
    this.pedido.situacao = 'ABERTO';

    this.pedido.valorTotal = this.count_valorTotal;
    this.pedido.quantidadeTotal = this.count_qtdTotal;
    this.pedido.percentualDesconto = this.count_desconto;

    // todo: Enviar para o backend

    // Testando como está o pedido
    console.log('pedido', this.pedido);

    // Limpando as somas após enviar o pedido
    this.cleanCount();

    // Todo: limpar o localStorage depois de enviar o pedido

    this._router.navigate(['/finalizado']);
  }
}
