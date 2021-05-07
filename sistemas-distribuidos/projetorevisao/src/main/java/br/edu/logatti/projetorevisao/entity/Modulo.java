package br.edu.logatti.projetorevisao.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Modulo {
    private Long id;
    private Ambiente ambiente;
    private Squad squad;

    public void update(final Modulo modulo) {
        this.ambiente = modulo.getAmbiente();
        this.squad = modulo.getSquad();
    }
}
