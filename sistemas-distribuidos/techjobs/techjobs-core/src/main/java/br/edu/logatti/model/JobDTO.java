package br.edu.logatti.model;

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
    private static final long serialVersionUID = -8331885081966266240L;
    private final String id;
    private final String nomeVaga;
    private final String cargoVaga;
    private final String techVaga;
}
