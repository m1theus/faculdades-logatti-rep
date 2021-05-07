package br.edu.logatti.projetorevisao.service;

import br.edu.logatti.projetorevisao.entity.Modulo;
import br.edu.logatti.projetorevisao.entity.Orcamento;
import br.edu.logatti.projetorevisao.repository.OrcamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrcamentoService {
    private final OrcamentoRepository repository;
    private final ModuloService moduloService;

    public List<Orcamento> findAll() {
        return repository.findAll();
    }

    public Orcamento findById(final String id) {
        return repository.findById(id).orElseThrow();
    }

    public Orcamento save(final Orcamento orcamento) {
        findModulo(orcamento);
        return repository.save(orcamento);
    }

    public Orcamento update(final String id, final Orcamento orcamento) {
        final Orcamento entity = findById(id);
        findModulo(orcamento);
        entity.update(orcamento);
        return repository.save(entity);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }

    private Orcamento findModulo(final Orcamento orcamento) {
        final var modulo = moduloService.findById(orcamento.getModulo().getId());
        orcamento.setModulo(modulo);
        return orcamento;
    }
}
