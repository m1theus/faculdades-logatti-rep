package br.edu.logatti.projetorevisao.service;

import br.edu.logatti.projetorevisao.entity.Ambiente;
import br.edu.logatti.projetorevisao.entity.Modulo;
import br.edu.logatti.projetorevisao.entity.Squad;
import br.edu.logatti.projetorevisao.repository.AmbienteRepository;
import br.edu.logatti.projetorevisao.repository.ModuloRepository;
import br.edu.logatti.projetorevisao.repository.SquadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuloService {
    private final ModuloRepository repository;
    private final AmbienteService ambienteService;
    private final SquadService squadService;

    public List<Modulo> findAll() {
        return repository.findAll();
    }

    public Modulo findById(final String id) {
        return repository.findById(id).orElseThrow();
    }

    public Modulo save(final Modulo modulo) {
        findAmbienteAndSquad(modulo);
        return repository.save(modulo);
    }

    public Modulo update(final String id, final Modulo modulo) {
        final Modulo entity = findById(id);
        findAmbienteAndSquad(modulo);
        entity.update(modulo);
        return repository.save(entity);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }

    private void findAmbienteAndSquad(final Modulo modulo) {
        final var ambiente = ambienteService.findById(modulo.getAmbiente().getId());
        final var squad = squadService.findById(modulo.getSquad().getId());
        modulo.setAmbiente(ambiente);
        modulo.setSquad(squad);
    }
}
