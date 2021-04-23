package br.edu.logatti.urbantransport.service;

import br.edu.logatti.urbantransport.entity.Empresa;
import br.edu.logatti.urbantransport.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository repository;

    public Empresa save(final Empresa empresa) {
        return repository.save(empresa);
    }

    public Empresa findByName(final String name) {
        return repository.findById(name)
                .orElseThrow(RuntimeException::new);
    }

    public void delete(final String name) {
        repository.deleteById(name);
    }
}
