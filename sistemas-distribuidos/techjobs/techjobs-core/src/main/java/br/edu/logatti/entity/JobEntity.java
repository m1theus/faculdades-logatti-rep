package br.edu.logatti.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Document
@ToString
@EqualsAndHashCode
public class JobEntity implements Serializable {
    @Id
    private String id;
    private final String nomeVaga;
    private final String cargoVaga;
    private final String techVaga;
    private final String obsVaga;

    public JobEntity(String nomeVaga, String cargoVaga, String techVaga, String obsVaga) {
        this.nomeVaga = nomeVaga;
        this.cargoVaga = cargoVaga;
        this.techVaga = techVaga;
        this.obsVaga = obsVaga;
    }

    public JobDTO toDTO() {
        return JobDTO.builder()
                .id(this.id)
                .nomeVaga(this.nomeVaga)
                .cargoVaga(this.cargoVaga)
                .techVaga(this.techVaga)
                .obsVaga(this.obsVaga)
                .build();
    }
}