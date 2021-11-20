import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/cliente.model';
import { Endereco } from 'src/app/models/endereco.model';
import { ClienteService } from 'src/app/services/cliente.service';
import { EnderecoService } from 'src/app/services/endereco.service';

@Component({
  selector: 'app-add-cliente',
  templateUrl: './add-cliente.component.html',
  styleUrls: ['./add-cliente.component.css'],
})
export class AddClienteComponent implements OnInit {
  clienteForm: FormGroup;

  idEndereco: number = 0;
  listEnderecos: Endereco[] = [];

  constructor(
    private _fb: FormBuilder,
    private _toastr: ToastrService,
    private _router: Router,
    private _service: ClienteService,
    private _serviceEndereco: EnderecoService
  ) {
    this.clienteForm = this._fb.group({
      // Para cada input do nosso formulário
      cpf: [''],
      cnpj: [''],
      nome: ['', Validators.required],
      status: ['', Validators.required],
      tipoCliente: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.getLastEnderecoId();
  }

  // Verificando o tipo de cliente
  // se estiver marcado (checked) é o cliente físico
  // então, eu quero limpar o campo que seja do CNPJ caso ele tenha sido digitado
  // isso é mais uma precaução, pois,
  // desta forma, eu garanto que não mandarei para o backend os 2 valores preenchidos,
  // respectivamente, dos campos CPF e CNPJ
  handleTipoCliente(value: boolean) {
    if (value) {
      this.clienteForm.controls.cnpj.setValue('');
    } else {
      this.clienteForm.controls.cpf.setValue('');
    }
  }

  /* Pegar o último Id cadastrado para o endereço */
  getLastEnderecoId(): void {
    this._serviceEndereco.getEnderecos().subscribe({
      next: (data) => {
        this.listEnderecos = data;
        this.idEndereco = this.listEnderecos.length;
      },
      error: (e) => console.log(e),
    });
  }

  addCliente() {
    //console.log(this.clienteForm.value);

    // Verificando qual o tipo de cliente
    let tipoDoCliente = this.clienteForm.get('tipoCliente')?.value;
    // Atribuindo alguns valores ao cliente
    let CLIENTE: Cliente = {
      nome: this.clienteForm.get('nome')?.value,
      cpf: '',
      cnpj: '',
      tipoCliente: '',
      endereco: this.idEndereco,
    };

    // Atribuindo o restante dos valores de acordo com o tipo de cliente
    if (tipoDoCliente) {
      console.log('>>> CLIENTE FÍSICO');
      CLIENTE.tipoCliente = 'FISICA';
      CLIENTE.cpf = this.clienteForm.get('cpf')?.value;
    } else {
      console.log('>>> CLIENTE JURÍDICO');
      CLIENTE.tipoCliente = 'JURIDICA ';
      CLIENTE.cnpj = this.clienteForm.get('cnpj')?.value;
    }

    // Uma outra forma que funcionaria
    // Mas tem campos repetidos...

    // if (tipoDoCliente) {
    //   console.log('>>> CLIENTE FÍSICO');
    //   CLIENTE = {
    //     cpf: this.clienteForm.get('cpf')?.value,
    //     nome: this.clienteForm.get('nome')?.value,
    //     tipoCliente: 'FISICA',
    //     endereco: this.idEndereco,
    //   };
    // } else {
    //   console.log('>>> CLIENTE JURÍDICO');
    //   CLIENTE = {
    //     cnpj: this.clienteForm.get('cnpj')?.value,
    //     nome: this.clienteForm.get('nome')?.value,
    //     tipoCliente: 'JURIDICA',
    //     endereco: this.idEndereco,
    //   };
    // }

    console.log(CLIENTE);

    this._service.postCliente(CLIENTE).subscribe({
      next: (data) => {
        console.log('Cliente cadastrado');
        this._toastr.success('Cadastrado com sucesso', 'Cliente');
        this._router.navigate(['']);
      },
      error: (e) => console.log(e),
    });
  }
}
