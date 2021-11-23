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
export class ChooseClienteComponent implements OnInit {
  public validacaoForm: FormGroup;
  listClientes: Cliente[] = [];

  public documento: string = '';
  public mostrarCliente: Cliente = {
    nome: '',
    tipoCliente: '',
    idEndereco: 0,
  };

  tipoCliente: boolean = true;

  constructor(
    private _service: ClienteService,
    private route: ActivatedRoute,
    private router: Router,
    private _fb: FormBuilder
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

  filtrarCliente() {
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
    localStorage.setItem("BD", JSON.stringify(this.mostrarCliente));
    this.validacaoForm.reset();
  }
}
