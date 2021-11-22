import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Cliente } from 'src/app/models/cliente.model';

@Component({
    selector: 'app-add-cliente',
    templateUrl: './choose-cliente.component.html',
    styleUrls: ['./choose-cliente.component.css'],
  })

export class ChooseClienteComponent implements OnInit{

    clienteForm: FormGroup;

    constructor(
        private _fb: FormBuilder,
      ) {
        this.clienteForm = this._fb.group({
          // Para cada input do nosso formulário
          cpf: [''],
          cnpj: [''],
        });
      }

      ngOnInit(): void {
          this.getOneCliente();
      }

      handleTipoCliente(value: boolean) {
        if (value) {
          this.clienteForm.controls.cnpj.setValue('');
        } else {
          this.clienteForm.controls.cpf.setValue('');
        }
      }

      getOneCliente() {
          // opção para dizer se é físico ou jurídico
        let tipoDoCliente = this.clienteForm.get('tipoCliente')?.value;
        let CLIENTE: Cliente = {
            nome: this.clienteForm.get('nome')?.value,
            tipoCliente: '',
          };
        // condição para colocar CPF ou CNPJ, de acordo com o tipo do
        if (tipoDoCliente) {
            console.log('>>> CLIENTE FÍSICO');
            CLIENTE.tipoCliente = 'FISICA';
            CLIENTE.cpf = this.clienteForm.get('cpf')?.value;
          } else {
            console.log('>>> CLIENTE JURÍDICO');
            CLIENTE.tipoCliente = 'JURIDICA';
            CLIENTE.cnpj = this.clienteForm.get('cnpj')?.value;
          }
          console.log(CLIENTE);
      } 
}

