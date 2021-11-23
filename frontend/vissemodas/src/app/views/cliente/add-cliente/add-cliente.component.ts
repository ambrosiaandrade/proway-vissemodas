import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
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

  title: string = 'Fazer';
  btn_text: string = 'Cadastrar';
  id: any;

  constructor(
    private _fb: FormBuilder,
    private _toastr: ToastrService,
    private _router: Router,
    private _service: ClienteService,
    private _serviceEndereco: EnderecoService,
    private _aRouter: ActivatedRoute
  ) {
    this.clienteForm = this._fb.group({
      // Para cada input do nosso formulário
      cpf: [''],
      cnpj: [''],
      nome: ['', Validators.required],
      status: ['', Validators.required],
      tipoCliente: ['', Validators.required],
      idEndereco: ['']
    });
    this.id = this._aRouter.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    this.isEditing();
  }

  // Verificando o tipo de cliente
  // se estiver marcado (checked) é o cliente físico
  // então, eu quero limpar o campo que seja do CNPJ caso ele tenha sido digitado
  // isso é mais uma precaução, pois,
  // para o backend só está indo um dos campos, ou CPF ou CNPJ
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
    // Verificando qual o tipo de cliente
    let tipoDoCliente = this.clienteForm.get('tipoCliente')?.value;
    // Atribuindo alguns valores ao cliente
    let CLIENTE: Cliente = {
      nome: this.clienteForm.get('nome')?.value,
      tipoCliente: '',
    };

    if ( this.id !== null ) { 
      // Atualizar cliente
      this._service.editCliente(this.id, CLIENTE).subscribe({
        next: (data) => {
          this._toastr.info('Editado com sucesso', 'Cliente');
          this._router.navigate(['/list-cliente']);
        },
        error: (e) => console.log(e),
      });
    } else {
      // Atribuindo o restante dos valores de acordo com o tipo de cliente
    if (tipoDoCliente) {
      //  console.log('>>> CLIENTE FÍSICO');
      CLIENTE.tipoCliente = 'FÍSICA';
      CLIENTE.cpf = this.clienteForm.get('cpf')?.value;
    } else {
      //  console.log('>>> CLIENTE JURÍDICO');
      CLIENTE.tipoCliente = 'JURÍDICA';
      CLIENTE.cnpj = this.clienteForm.get('cnpj')?.value;
    }
  } 
  
  this._service.postCliente(CLIENTE).subscribe({
    next: (data) => {
      console.log('Cliente cadastrado');
      this._toastr.success('Cadastrado com sucesso', 'Cliente');
      this._router.navigate(['']);
    },
    error: (e) => {
      this._toastr.error(e, 'Cliente');
    },
  });
}
    

  isEditing() {
    if (this.id !== null) {
      this.title = 'Editar';
      this.btn_text = 'Editar';

      this._service.getOneCliente(this.id).subscribe({
        next: (data) => {
          // Atualizando os valores no clienteForm
          this.clienteForm.patchValue({
            cpf: data.cpf,
            cnpj: data.cnpj,
            nome: data.nome,
            status: data.status,
            tipoCliente: data.tipoCliente,
          });
        },
        error: (e) => console.log(e),
      });
    }
  }
}
