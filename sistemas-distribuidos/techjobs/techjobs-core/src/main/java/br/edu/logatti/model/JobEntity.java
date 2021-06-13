package br.edu.logatti.model;

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
    private static final long serialVersionUID = -3459258165289359555L;
    @Id
    private String id;
    private final String nomeVaga;
    private final String cargoVaga;
    private final String techVaga;

    public JobEntity(String nomeVaga, String cargoVaga, String techVaga) {
        this.nomeVaga = nomeVaga;
        this.cargoVaga = cargoVaga;
        this.techVaga = techVaga;
    }

    public JobDTO toDTO() {
        return JobDTO.builder()
                .id(this.id)
                .nomeVaga(this.nomeVaga)
                .cargoVaga(this.cargoVaga)
                .techVaga(this.techVaga)
                .build();
    }
}