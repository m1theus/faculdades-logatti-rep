package br.edu.logatti.urbantransport.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TB_QUADRO_HORARIO")
public class QuadroHorario {
    @Id
    private Long id;
}
