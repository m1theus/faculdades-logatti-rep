package br.edu.logatti.projetorevisao.resource;

import br.edu.logatti.projetorevisao.entity.Ambiente;
import br.edu.logatti.projetorevisao.service.AmbienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ambiente")
public class AmbienteResource {
    public static final String ID_PATH = "/{id}";
    private final AmbienteService service;

    @GetMapping
    public ResponseEntity<List<Ambiente>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_PATH)
    public ResponseEntity<Ambiente> findById(@PathVariable final String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Ambiente> save(@RequestBody final Ambiente ambiente) {
        return ResponseEntity.status(CREATED).body(service.save(ambiente));
    }

    @PutMapping(ID_PATH)
    public ResponseEntity<Ambiente> update(@PathVariable final String id, @RequestBody final Ambiente ambiente) {
        return ResponseEntity.ok(service.update(id, ambiente));
    }

    @DeleteMapping(ID_PATH)
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
