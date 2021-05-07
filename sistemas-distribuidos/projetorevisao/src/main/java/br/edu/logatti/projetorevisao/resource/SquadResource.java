package br.edu.logatti.projetorevisao.resource;

import br.edu.logatti.projetorevisao.entity.Squad;
import br.edu.logatti.projetorevisao.service.SquadService;
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
@RequestMapping("/api/squad")
public class SquadResource {
    public static final String ID_PATH = "/{id}";
    private final SquadService service;

    @GetMapping
    public ResponseEntity<List<Squad>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_PATH)
    public ResponseEntity<Squad> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Squad> save(@RequestBody final Squad squad) {
        return ResponseEntity.status(CREATED).body(service.save(squad));
    }

    @PutMapping(ID_PATH)
    public ResponseEntity<Squad> update(@PathVariable final Long id, @RequestBody final Squad squad) {
        return ResponseEntity.ok(service.update(id, squad));
    }

    @DeleteMapping(ID_PATH)
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
