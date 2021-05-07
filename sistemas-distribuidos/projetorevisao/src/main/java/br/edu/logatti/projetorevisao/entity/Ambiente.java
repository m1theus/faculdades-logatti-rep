package br.edu.logatti.projetorevisao.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Ambiente {
    private Long id;
    private String descricao;

    public void update(final Ambiente ambiente) {
        this.descricao = ambiente.getDescricao();
    }
}
