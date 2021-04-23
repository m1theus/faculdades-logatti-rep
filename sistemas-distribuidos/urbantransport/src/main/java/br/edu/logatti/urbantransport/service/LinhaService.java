package br.edu.logatti.urbantransport.service;

import br.edu.logatti.urbantransport.entity.Linha;
import br.edu.logatti.urbantransport.repository.LinhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinhaService {
    private final LinhaRepository repository;

    public Linha save(Linha linha) {
        return repository.save(linha);
    }

    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
