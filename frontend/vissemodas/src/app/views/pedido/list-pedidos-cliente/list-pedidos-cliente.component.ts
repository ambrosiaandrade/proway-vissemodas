import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-pedidos-cliente',
  templateUrl: './list-pedidos-cliente.component.html',
  styleUrls: ['./list-pedidos-cliente.component.css']
})
export class ListPedidosClienteComponent implements OnInit {

  // TODO: Puxar do itemPedidos de acordo com o cliente
  // vai ser um componente usado no choose-cliente
  // listando abaixo os pedidos

  // TODO: ajustar o choose-cliente para verificar se é compra ou se é meusPedidos do cliente
  constructor() { }

  ngOnInit(): void {
  }

}
