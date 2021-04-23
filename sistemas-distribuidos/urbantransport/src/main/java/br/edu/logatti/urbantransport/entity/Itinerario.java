package br.edu.logatti.urbantransport.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TB_ITINERARIO")
public class Itinerario {
    @Id
    private String nome;
    private int ordem;
}
