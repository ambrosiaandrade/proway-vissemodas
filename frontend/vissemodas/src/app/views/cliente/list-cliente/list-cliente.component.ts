import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente.model';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-list-cliente',
  templateUrl: './list-cliente.component.html',
  styleUrls: ['./list-cliente.component.css']
})
export class ListClienteComponent implements OnInit {

  listaClientes: Cliente[] = [];

  constructor(private _service: ClienteService) { }

  ngOnInit(): void {
    this.listarClientes();
  }

  listarClientes() {
    return this._service.getClientes().subscribe({
      next: (data) => {
        this.listaClientes = data;
      },
      error: (e) => console.log(e),
    });
  }
}
