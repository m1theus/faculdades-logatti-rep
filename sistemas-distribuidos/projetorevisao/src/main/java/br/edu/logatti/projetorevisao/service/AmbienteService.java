package br.edu.logatti.projetorevisao.service;

import br.edu.logatti.projetorevisao.entity.Ambiente;
import br.edu.logatti.projetorevisao.repository.AmbienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmbienteService {
    private final AmbienteRepository repository;

    public List<Ambiente> findAll() {
        return repository.findAll();
    }

    public Ambiente findById(final String id) {
        return repository.findById(id).orElseThrow();
    }

    public Ambiente save(final Ambiente ambiente) {
        return repository.save(ambiente);
    }

    public Ambiente update(final String id, final Ambiente ambiente) {
        final Ambiente entity = findById(id);
        entity.update(ambiente);
        return repository.save(entity);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }
}
