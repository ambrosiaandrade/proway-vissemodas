import { BinaryOperator } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConsultaCepService } from 'src/app/services/consulta-cep.service';

@Component({
  selector: 'app-add-endereco',
  templateUrl: './add-endereco.component.html',
  styleUrls: ['./add-endereco.component.css']
})
export class AddEnderecoComponent implements OnInit {
  
  enderecoForm: FormGroup
  constructor(private _fb: FormBuilder, private CepService: ConsultaCepService) {
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
  }

}
