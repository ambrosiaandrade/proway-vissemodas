import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddClienteComponent } from './views/cliente/add-cliente/add-cliente.component';
import { ListClienteComponent } from './views/cliente/list-cliente/list-cliente.component';
import { CarrinhoComponent } from './views/carrinho/carrinho.component';
import { AddEnderecoComponent } from './views/endereco/add-endereco/add-endereco.component';
import { HomeComponent } from './views/home/home.component';
import { AddProdutoComponent } from './views/produto/add-produto/add-produto.component';
import { ListProdutoComponent } from './views/produto/list-produto/list-produto.component';
import { FinalizadoComponent } from './views/finalizado/finalizado.component';
import { AdminListProdutoComponent } from './views/produto/admin-list-produto/admin-list-produto.component';
import { HistoryPedidoComponent } from './views/pedido/history-pedido/history-pedido.component';
import { ChooseClienteComponent } from './views/cliente/choose-cliente/choose-cliente.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'add-produto', component: AddProdutoComponent },
  { path: 'edit-produto/:id', component: AddProdutoComponent },
  { path: 'list-produto', component: ListProdutoComponent },
  { path: 'admin-list-produto', component: AdminListProdutoComponent },
  { path: 'add-cliente', component: AddClienteComponent },
  { path: 'list-cliente', component: ListClienteComponent },
  { path: 'edit-cliente/:id', component: AddClienteComponent }, // editar cliente (não sei se era necessário, mas fiz porque confundi com o edit endereço)
  { path: 'add-endereco', component: AddEnderecoComponent },
  { path: 'edit-endereco/:id', component: AddEnderecoComponent }, // editar endereço (esse era o correto para fazer)
  { path: 'choose-cliente', component: ChooseClienteComponent },
  { path: 'carrinho', component: CarrinhoComponent },
  { path: 'finalizado', component: FinalizadoComponent },
  { path: 'history-pedido', component: HistoryPedidoComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
