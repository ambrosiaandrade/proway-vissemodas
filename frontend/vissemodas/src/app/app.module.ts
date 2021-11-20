import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { HttpClientModule } from '@angular/common/http';

// Componentes
import { AddProdutoComponent } from './views/produto/add-produto/add-produto.component';
import { ListProdutoComponent } from './views/produto/list-produto/list-produto.component';
import { HomeComponent } from './views/home/home.component';
import { NavbarComponent } from './views/shared/navbar/navbar.component';
import { FooterComponent } from './views/shared/footer/footer.component';
import { AddClienteComponent } from './views/cliente/add-cliente/add-cliente.component';
import { ListClienteComponent } from './views/cliente/list-cliente/list-cliente.component';
import { AddEnderecoComponent } from './views/endereco/add-endereco/add-endereco.component';
import { CarrinhoComponent } from './views/carrinho/carrinho.component';
import { FinalizadoComponent } from './views/finalizado/finalizado.component';
import { AdminListProdutoComponent } from './views/produto/admin-list-produto/admin-list-produto.component';

// Mask


@NgModule({
  declarations: [
    AppComponent,
    AddProdutoComponent,
    ListProdutoComponent,
    AddClienteComponent,
    ListClienteComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    AddEnderecoComponent,
    CarrinhoComponent,
    FinalizadoComponent,
    AdminListProdutoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}