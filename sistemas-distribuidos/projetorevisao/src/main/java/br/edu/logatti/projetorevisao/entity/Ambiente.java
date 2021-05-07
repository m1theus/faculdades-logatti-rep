package br.edu.logatti.projetorevisao.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Ambiente {
    @Id
    private String id;
    private String descricao;

    public void update(final Ambiente ambiente) {
        this.descricao = ambiente.getDescricao();
    }
}
