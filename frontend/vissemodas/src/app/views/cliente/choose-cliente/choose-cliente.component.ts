import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Cliente } from 'src/app/models/cliente.model';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
    selector: 'app-add-cliente',
    templateUrl: './choose-cliente.component.html',
    styleUrls: ['./choose-cliente.component.css'],
  })

export class ChooseClienteComponent implements OnInit{

    listClientes: Cliente[] = [];

    constructor(private _service: ClienteService){
       
      }

      ngOnInit(): void {
        this.buscarClientes();
      }

      handleTipoCliente(value: boolean) {
        if (value) {
         
        } else {
          
        }
      }

      buscarClientes() {
          this._service.getClientes().subscribe({
              next: (data)=> {
                  this.listClientes = data;
                  console.log(data)
              },
              error: (e) => console.log(e)
          })
      }
}

