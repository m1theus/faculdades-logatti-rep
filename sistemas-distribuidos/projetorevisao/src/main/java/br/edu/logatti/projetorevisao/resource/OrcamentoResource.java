package br.edu.logatti.projetorevisao.resource;

import br.edu.logatti.projetorevisao.entity.Orcamento;
import br.edu.logatti.projetorevisao.service.OrcamentoService;
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
@RequestMapping("/api/orcamento")
public class OrcamentoResource {
    public static final String ID_PATH = "/{id}";
    private final OrcamentoService service;

    @GetMapping
    public ResponseEntity<List<Orcamento>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_PATH)
    public ResponseEntity<Orcamento> findById(@PathVariable final String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Orcamento> save(@RequestBody final Orcamento orcamento) {
        return ResponseEntity.status(CREATED).body(service.save(orcamento));
    }

    @PutMapping(ID_PATH)
    public ResponseEntity<Orcamento> update(@PathVariable final String id, @RequestBody final Orcamento orcamento) {
        return ResponseEntity.ok(service.update(id, orcamento));
    }

    @DeleteMapping(ID_PATH)
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}