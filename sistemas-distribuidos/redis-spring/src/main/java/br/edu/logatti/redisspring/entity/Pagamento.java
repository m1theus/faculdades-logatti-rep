package br.edu.logatti.redisspring.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Document
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 4962119706618232125L;
    @Id
    private String id;
    private String descricao;
    private String tipo;
    private LocalDateTime data = LocalDateTime.now();
    private Double valor;
}
