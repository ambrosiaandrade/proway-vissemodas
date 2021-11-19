import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr'; 
import { Produto } from 'src/app/models/produto.model';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-add-produto',
  templateUrl: './add-produto.component.html',
  styleUrls: ['./add-produto.component.css']
})
export class AddProdutoComponent implements OnInit {

  produtoForm: FormGroup;

  constructor(private _fb: FormBuilder, private _toastr: ToastrService, 
              private _router: Router, private _service: ProdutoService) {
    this.produtoForm = this._fb.group({
      // Para cada input do nosso formulário
      descricao: ['', Validators.required],
      tamanho: ['', Validators.required],
      valorUnitario: ['', Validators.required],
      status: ['', Validators.required],
      imagem: ['', Validators.required],
      categoria: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  addProduto(){
    console.log(this.produtoForm.value);
    const PRODUTO: Produto = {
      descricao: this.produtoForm.get('descricao')?.value,
      tamanho: this.produtoForm.get('tamanho')?.value,
      valorUnitario: this.produtoForm.get('valorUnitario')?.value,
      status: this.produtoForm.get('status')?.value,
      imagem: this.produtoForm.get('imagem')?.value,
      categoria: this.produtoForm.get('categoria')?.value,
    }

    this._service.postProduto(PRODUTO).subscribe({
      next: (data) => {
        console.log("Produto cadastrado");
        this._toastr.success('Cadastrado com sucesso', 'Produto');
        this._router.navigate(['']);
      },
      error: (e) => console.log(e)
    });
  }

}
