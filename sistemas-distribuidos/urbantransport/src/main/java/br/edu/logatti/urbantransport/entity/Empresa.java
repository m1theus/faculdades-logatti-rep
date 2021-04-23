package br.edu.logatti.urbantransport.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TB_EMPRESA")
public class Empresa {
    @Id
    private String nome;
    private String endereco;
    private String telefone;
    private String website;
}
