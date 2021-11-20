import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Endereco } from '../models/endereco.model';

@Injectable({
  providedIn: 'root',
})
export class EnderecoService {
  private readonly url = 'http://localhost:8080/enderecos';

  constructor(private _http: HttpClient) {}

  getEnderecos(): Observable<any> {
    return this._http.get(this.url);
  }

  postEndereco(endereco: Endereco): Observable<any> {
    return this._http.post(this.url, endereco);
  }

  deleteEndereco(id: any): Observable<any> {
    return this._http.delete(`${this.url}/${id}`);
  }
}
