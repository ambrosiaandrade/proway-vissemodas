package br.com.capgemini.visseModas.maressa.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ClientePF extends Cliente {

    private String cpf;

}
