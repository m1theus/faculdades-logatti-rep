package br.edu.logatti.avaliacaoredis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.stream.Stream;

@Data
@Document
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = -4291133914241277359L;
    @Id
    private String id;
    private String aluno;
    private String disciplina;
    private int nota1;
    private int nota2;
    private int nota3;

    public void update(final Avaliacao avaliacao) {
        if (avaliacao == null) {
            return;
        }

        aluno = avaliacao.getAluno();
        disciplina = avaliacao.getDisciplina();
        nota1 = avaliacao.getNota1();
        nota2 = avaliacao.getNota2();
        nota3 = avaliacao.getNota3();
    }

    @JsonProperty
    public double media() {
        return Stream.of(nota1, nota2, nota3)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }
}
