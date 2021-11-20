export class Cliente{

    id?: number;
    cpf: string;
    cnpj: string;
    nome: string;
    status: boolean;
    tipoCliente: string;

    constructor(cpf: string, cnpj: string, 
                nome: string, status: boolean, tipoCliente: string){
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.nome = nome;
        this.status = status;
        this.tipoCliente = tipoCliente;
    }

}