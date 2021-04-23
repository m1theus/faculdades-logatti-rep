package br.edu.logatti.urbantransport.service;

import br.edu.logatti.urbantransport.entity.Itinerario;
import br.edu.logatti.urbantransport.repository.ItinerarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItinerarioService {
    private final ItinerarioRepository repository;

    public Itinerario save(final Itinerario itinerario) {
        return repository.save(itinerario);
    }

    public Itinerario findByName(final String name) {
        return repository.findById(name)
                .orElseThrow(RuntimeException::new);
    }

    public void delete(final String name) {
        repository.deleteById(name);
    }

}
