package br.edu.logatti.projetorevisao.resource;

import br.edu.logatti.projetorevisao.entity.Modulo;
import br.edu.logatti.projetorevisao.service.ModuloService;
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
@RequestMapping("/api/modulo")
public class ModuloResource {
    public static final String ID_PATH = "/{id}";
    private final ModuloService service;

    @GetMapping
    public ResponseEntity<List<Modulo>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_PATH)
    public ResponseEntity<Modulo> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Modulo> save(@RequestBody final Modulo modulo) {
        return ResponseEntity.status(CREATED).body(service.save(modulo));
    }

    @PutMapping(ID_PATH)
    public ResponseEntity<Modulo> update(@PathVariable final Long id, @RequestBody final Modulo modulo) {
        return ResponseEntity.ok(service.update(id, modulo));
    }

    @DeleteMapping(ID_PATH)
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}