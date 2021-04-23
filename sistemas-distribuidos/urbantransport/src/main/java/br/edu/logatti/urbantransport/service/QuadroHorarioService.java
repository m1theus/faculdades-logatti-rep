package br.edu.logatti.urbantransport.service;

import br.edu.logatti.urbantransport.entity.QuadroHorario;
import br.edu.logatti.urbantransport.repository.QuadroHorarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuadroHorarioService {
    private final QuadroHorarioRepository repository;

    public QuadroHorario save(final QuadroHorario quadroHorario) {
        return repository.save(quadroHorario);
    }
}
