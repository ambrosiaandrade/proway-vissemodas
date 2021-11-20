import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr'; 
import { Cliente } from 'src/app/models/cliente.model';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({ 
  selector: 'app-add-cliente',
  templateUrl: './add-cliente.component.html',
  styleUrls: ['./add-cliente.component.css']
})
export class AddClienteComponent implements OnInit {

  clienteForm: FormGroup;

  constructor(private _fb: FormBuilder, private _toastr: ToastrService, 
              private _router: Router, private _service: ClienteService) {
    this.clienteForm = this._fb.group({
      // Para cada input do nosso formulário
      cpf: ['', Validators.required],
      cnpj: ['', Validators.required],
      nome: ['', Validators.required],
      status: ['', Validators.required],
      tipoCliente: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  addProduto(){
    console.log(this.clienteForm.value);
    const CLIENTE: Cliente = {
      cpf: this.clienteForm.get('cpf')?.value,
      cnpj: this.clienteForm.get('cnpj')?.value,
      nome: this.clienteForm.get('nome')?.value,
      status: this.clienteForm.get('status')?.value,
      tipoCliente: this.clienteForm.get('tipoCliente')?.value,
    }

    this._service.postCliente(CLIENTE).subscribe({
      next: (data) => {
        console.log("Cliente cadastrado");
        this._toastr.success('Cadastrado com sucesso', 'Cliente');
        this._router.navigate(['']);
      },
      error: (e) => console.log(e)
    });
  }

}
