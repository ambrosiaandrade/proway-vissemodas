import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { AddProdutoComponent } from './views/produto/add-produto/add-produto.component';
import { ListProdutoComponent } from './views/produto/list-produto/list-produto.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'add-produto', component: AddProdutoComponent},
  {path: 'list-produto', component: ListProdutoComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
