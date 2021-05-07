package br.edu.logatti.projetorevisao.service;

import br.edu.logatti.projetorevisao.entity.Modulo;
import br.edu.logatti.projetorevisao.repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuloService {
    private final ModuloRepository repository;

    public List<Modulo> findAll() {
        return repository.findAll();
    }

    public Modulo findById(final Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Modulo save(final Modulo modulo) {
        return repository.save(modulo);
    }

    public Modulo update(final Long id, final Modulo modulo) {
        final Modulo entity = findById(id);
        entity.update(modulo);
        return repository.save(entity);
    }

    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
