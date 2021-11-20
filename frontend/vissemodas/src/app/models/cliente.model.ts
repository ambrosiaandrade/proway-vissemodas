export class Cliente {
  id?: number;
  cpf?: string;
  cnpj?: string;
  nome: string;
  status?: boolean;
  tipoCliente: string;
  idEndereco: number;

  constructor(
    cpf: string,
    cnpj: string,
    nome: string,
    tipoCliente: string,
    idEndereco: number
  ) {
    this.cpf = cpf;
    this.cnpj = cnpj;
    this.nome = nome;
    this.status = true;
    this.tipoCliente = tipoCliente;
    this.idEndereco = idEndereco;
  }
}
