import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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
import { ChooseClienteComponent } from './views/cliente/choose-cliente/choose-cliente.component';
import { AddEnderecoComponent } from './views/endereco/add-endereco/add-endereco.component';
import { CarrinhoComponent } from './views/carrinho/carrinho.component';
import { FinalizadoComponent } from './views/finalizado/finalizado.component';
import { AdminListProdutoComponent } from './views/produto/admin-list-produto/admin-list-produto.component';
import { HistoryPedidoComponent } from './views/pedido/history-pedido/history-pedido.component';

// Mask
import { NgxMaskModule } from 'ngx-mask';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    AddProdutoComponent,
    ListProdutoComponent,
    AddClienteComponent,
    ListClienteComponent,
    ChooseClienteComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    AddEnderecoComponent,
    CarrinhoComponent,
    FinalizadoComponent,
    AdminListProdutoComponent,
    HistoryPedidoComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    NgxMaskModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}