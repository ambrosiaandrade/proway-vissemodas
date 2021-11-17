package br.com.capgemini.visseModas.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum TipoCliente {

    FISICA("Física", "CPF", "000.000.000-00", CPFGroup.class),
    JURIDICA("Jurídica", "CNPJ", "00.000.000/0000-00", CNPJGroup.class);

    private final String descricao;
    private final String documento;
    private final String mascara;
    private final Class<?> group;

    private TipoCliente(String descricao, String documento, String mascara, Class<?> group) {
        this.descricao = descricao;
        this.documento = documento;
        this.mascara = mascara;
        this.group = group;
    }





}
