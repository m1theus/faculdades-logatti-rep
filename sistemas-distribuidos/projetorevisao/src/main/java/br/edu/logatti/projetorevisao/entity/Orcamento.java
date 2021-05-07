package br.edu.logatti.projetorevisao.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class Orcamento {
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long quantidadeDias;
    private String descricao;
    private String titulo;
    private Modulo modulo;

    public void update(final Orcamento orcamento) {
        this.dataInicio = orcamento.getDataInicio();
        this.dataFim = orcamento.getDataFim();
        this.quantidadeDias = orcamento.getQuantidadeDias();
        this.descricao = orcamento.getDescricao();
        this.titulo = orcamento.getTitulo();
        this.modulo = orcamento.getModulo();
    }
}
