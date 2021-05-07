package br.edu.logatti.projetorevisao.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Squad {
    private Long id;
    private String nome;
    private Long quantidadePessoas;

    public void update(final Squad squad) {
        this.nome = squad.getNome();
        this.quantidadePessoas = squad.getQuantidadePessoas();
    }
}
