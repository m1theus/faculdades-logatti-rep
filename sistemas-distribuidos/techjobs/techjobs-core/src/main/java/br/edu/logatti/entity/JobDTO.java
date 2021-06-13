package br.edu.logatti.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class JobDTO implements Serializable {
    private final String id;
    private final String nomeVaga;
    private final String cargoVaga;
    private final String techVaga;
    private final String obsVaga;
}
