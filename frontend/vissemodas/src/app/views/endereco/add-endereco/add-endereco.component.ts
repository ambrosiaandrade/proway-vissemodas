import { BinaryOperator } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Endereco } from 'src/app/models/endereco.model';
import { ConsultaCepService } from 'src/app/services/consulta-cep.service';
import { EnderecoService } from 'src/app/services/endereco.service';

@Component({
  selector: 'app-add-endereco',
  templateUrl: './add-endereco.component.html',
  styleUrls: ['./add-endereco.component.css']
})
export class AddEnderecoComponent implements OnInit {
  
  enderecoForm: FormGroup

  constructor(private _fb: FormBuilder, private CepService: ConsultaCepService, 
   private _service: EnderecoService) {
    this.enderecoForm = _fb.group({
      cep: ['', Validators.required],
      logradouro: ['', Validators.required],
      cidade: ['', Validators.required],
      estado: ['', Validators.required],
      bairro: ['', Validators.required],
      numero: ['', Validators.required]
    });
   }

  ngOnInit(): void {
  }

  populaFormEndereco(dados: any){
    console.log(dados)
    this.enderecoForm.patchValue({
      logradouro: dados.logradouro,
      cidade: dados.localidade,
      estado: dados.uf,
      bairro: dados.bairro
    })
  }
  consultaCEP(){
    let cep = this.enderecoForm.get('cep')?.value;
    if(cep != null && cep !== ''){
      this.CepService.consultaCEP(cep)?.subscribe(dados => this.populaFormEndereco(dados))
      
    }
  }

  addEndereco(){
    console.log(this.enderecoForm.value)
    console.log(this.enderecoForm.get('cep')?.value)
    const ENDERECO: Endereco = {
      cep: this.enderecoForm.get('cep')?.value,
      logradouro: this.enderecoForm.get('logradouro')?.value,
      cidade: this.enderecoForm.get('cidade')?.value,
      estado: this.enderecoForm.get('estado')?.value,
      bairro: this.enderecoForm.get('bairro')?.value,
      numero: this.enderecoForm.get('numero')?.value,
    }
    this._service.postEndereco(ENDERECO).subscribe({
      next: (data: any) => {
        console.log("Endereço cadastrado")
      },
      error: (e) => console.log(e)
    })
  }

}
