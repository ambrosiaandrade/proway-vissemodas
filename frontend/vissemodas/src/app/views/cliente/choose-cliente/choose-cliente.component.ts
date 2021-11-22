import { templateJitUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente.model';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
    selector: 'app-choose-cliente',
    templateUrl: './choose-cliente.component.html',
    styleUrls: ['./choose-cliente.component.css'],
  })

export class ChooseClienteComponent implements OnInit{

    validacaoForm: FormGroup;
    listClientes: Cliente[] = [];
    public cpf!: String;
    public cnpj!: String;
    public clienteCpf: any;
    public documento: any;
    public mostrarCliente: Cliente = {
        nome: '',
        tipoCliente: ''
    };
    tipoCliente: boolean = true;
    
    constructor(private _service: ClienteService, private route: ActivatedRoute,
                private router: Router, private _fb: FormBuilder){
        this.validacaoForm = _fb.group({
            cpf: [''],
            cnpj: ['']
        })
    }

      ngOnInit(): void {
        this.buscarClientes();
      }      

      handleTipoCliente(value: boolean) {
        if (value) {
            this.documento = this.cpf;
            this.tipoCliente = true;
            console.log(this.validacaoForm.get('cpf')?.value);
            
        } else {
            this.documento = this.cnpj;
            this.tipoCliente = false;
            console.log(this.validacaoForm.get('cnpj')?.value);
            
        }
      }

      buscarClientes() {
          this._service.getClientes().subscribe({
              next: (data) => {
                  this.listClientes = data;
                  this.cpf = this.validacaoForm.get('cpf')?.value;
                  this.cnpj = this.validacaoForm.get('cnpj')?.value;
                  console.log(data);
                  console.log(this.documento);
              },
              error: (e) => console.log(e)
          })
      }

      

      buscarClientesPorId(documento: any): void {
          if (this.tipoCliente) {
              for (let i = 0; i < this.listClientes.length; i++) {
                if (documento == this.listClientes[i].cpf) {
                    this.mostrarCliente = this.listClientes[i];
                } 
              }
          } else {
            for (let i = 0; i < this.listClientes.length; i++) {
                if (documento == this.listClientes[i].cnpj) {
                    this.mostrarCliente = this.listClientes[i];
                } 
              }
          }
          
    }

}

