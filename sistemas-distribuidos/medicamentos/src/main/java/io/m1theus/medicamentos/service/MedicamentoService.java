package io.m1theus.medicamentos.service;

import io.m1theus.medicamentos.exception.ResourceNotFoundException;
import io.m1theus.medicamentos.model.Medicamento;
import io.m1theus.medicamentos.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository repository;

    public MedicamentoService(MedicamentoRepository repository) {
        this.repository = repository;
    }

    public Medicamento findById(final String id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Medicamento> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Medicamento save(final Medicamento medicamento) {
        return repository.save(medicamento);
    }

    @Transactional
    public Medicamento update(final String id, final Medicamento medicamento) {
        final Medicamento entity = findById(id);
        entity.setDescricao(medicamento.getDescricao());
        entity.setOrigem(medicamento.getOrigem());
        entity.setFabricante(medicamento.getFabricante());
        return repository.save(entity);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }

}
