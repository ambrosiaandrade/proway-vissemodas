import { templateJitUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente.model';
import { ClienteService } from 'src/app/services/cliente.service';
import { ToastrService } from 'ngx-toastr';
import { EnderecoService } from '../../../services/endereco.service';
import { Endereco } from 'src/app/models/endereco.model';

@Component({
  selector: 'app-choose-cliente',
  templateUrl: './choose-cliente.component.html',
  styleUrls: ['./choose-cliente.component.css'],
})
export class ChooseClienteComponent implements OnInit {
  validacaoForm: FormGroup;
  listClientes: Cliente[] = [];

  documento: string = '';
  mostrarCliente: Cliente = {
    nome: '',
    tipoCliente: '',
    idEndereco: 0,
  };
  enderecoCliente: Endereco = {
    cep: '',
    estado: '',
    cidade: '',
    bairro: '',
    logradouro: '',
    numero: 0,
  };

  tipoCliente: boolean = true;
  botaoTexto: string = 'Buscar';

  constructor(
    private _service: ClienteService,
    private _serviceEndereco: EnderecoService,
    private route: ActivatedRoute,
    private router: Router,
    private _fb: FormBuilder,
    private _toastr: ToastrService
  ) {
    this.validacaoForm = _fb.group({
      cpf: [''],
      cnpj: [''],
    });
  }

  ngOnInit(): void {
    this.buscarClientes();
  }

  handleTipoCliente(value: boolean) {
    if (!value) {
      this.tipoCliente = false;
    } else {
      this.tipoCliente = true;
    }
  }

  buscarClientes() {
    this._service.getClientes().subscribe({
      next: (data) => {
        this.listClientes = data;
        console.log(data);
      },
      error: (e) => console.log(e),
    });
  }

  buscarEnderecoCliente(id: number | undefined) {
    this._serviceEndereco.getOneEndereco(id).subscribe({
      next: (data) => (this.enderecoCliente = data),
      error: (e) => console.log(e),
    });
  }

  buscarClientePeloDocumento(documento: string): void {
    if (!this.tipoCliente) {
      for (let i = 0; i < this.listClientes.length; i++) {
        let documentoSemPontuacao = this.listClientes[i].cnpj?.replace(
          /\D/g,
          ''
        );
        if (documento == documentoSemPontuacao) {
          this.mostrarCliente = this.listClientes[i];
          console.log(this.mostrarCliente);
        }
      }
    } else {
      for (let i = 0; i < this.listClientes.length; i++) {
        let documentoSemPontuacao = this.listClientes[i].cpf?.replace(
          /\D/g,
          ''
        );
        if (documento == documentoSemPontuacao) {
          this.mostrarCliente = this.listClientes[i];
          console.log(this.mostrarCliente);
        }
      }
    }

    console.log('mostrarCliente', this.mostrarCliente);
  }

  hasCliente(): boolean {
    if (this.mostrarCliente.nome.length > 0) {
      this.botaoTexto = 'Continuar compra';
      this.buscarEnderecoCliente(this.mostrarCliente.idEndereco);
      return true;
    } else {
      return false;
    }
  }

  handleCliente() {
    this.validacaoForm.patchValue({
      cpf: this.validacaoForm.get('cpf')?.value,
      cnpj: this.validacaoForm.get('cnpj')?.value,
    });

    if (this.tipoCliente) {
      this.documento = this.validacaoForm.controls.cpf.value;
    } else {
      this.documento = this.validacaoForm.controls.cnpj.value;
    }

    this.buscarClientePeloDocumento(this.documento);

    // Antes de salvar no localStorage verificar se existe o cliente
    if (this.hasCliente()) {
      localStorage.setItem('client', JSON.stringify(this.mostrarCliente));
    } else {
      this._toastr.error('Inválido', 'Cliente');
    }

    this.validacaoForm.reset();
  }
}
