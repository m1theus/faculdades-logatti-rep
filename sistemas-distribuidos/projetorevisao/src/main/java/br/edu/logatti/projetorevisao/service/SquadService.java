package br.edu.logatti.projetorevisao.service;

import br.edu.logatti.projetorevisao.entity.Squad;
import br.edu.logatti.projetorevisao.repository.SquadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SquadService {
    private final SquadRepository repository;

    public List<Squad> findAll() {
        return repository.findAll();
    }

    public Squad findById(final Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Squad save(final Squad squad) {
        return repository.save(squad);
    }

    public Squad update(final Long id, final Squad squad) {
        final Squad entity = findById(id);
        entity.update(squad);
        return repository.save(entity);
    }

    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
