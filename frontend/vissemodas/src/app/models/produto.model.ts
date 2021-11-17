export class Produto{

    id?: number;
    descricao: string;
    tamanho: string;
    valorUnitario: number;
    status: boolean;

    constructor(descricao: string, tamanho: string,
                valorUnitario: number, status: boolean){
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.valorUnitario = valorUnitario;
        this.status = true;
    }

}