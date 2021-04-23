package br.edu.logatti.urbantransport.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TB_LINHA")
public class Linha {
    @Id
    private Long id;
    private String nome;
}
