package br.edu.logatti.projetorevisao.service;

import br.edu.logatti.projetorevisao.entity.Orcamento;
import br.edu.logatti.projetorevisao.repository.OrcamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrcamentoService {
    private final OrcamentoRepository repository;

    public List<Orcamento> findAll() {
        return repository.findAll();
    }

    public Orcamento findById(final Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Orcamento save(final Orcamento orcamento) {
        return repository.save(orcamento);
    }

    public Orcamento update(final Long id, final Orcamento orcamento) {
        final Orcamento entity = findById(id);
        entity.update(orcamento);
        return repository.save(entity);
    }

    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
