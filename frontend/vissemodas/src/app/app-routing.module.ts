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

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'add-produto', component: AddProdutoComponent },
  { path: 'edit-produto/:id', component: AddProdutoComponent },
  { path: 'list-produto', component: ListProdutoComponent },
  { path: 'admin-list-produto', component: AdminListProdutoComponent },
  { path: 'add-cliente', component: AddClienteComponent },
  { path: 'list-cliente', component: ListClienteComponent },
  { path: 'add-endereco', component: AddEnderecoComponent },
  { path: 'carrinho', component: CarrinhoComponent },
  { path: 'finalizado', component: FinalizadoComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
