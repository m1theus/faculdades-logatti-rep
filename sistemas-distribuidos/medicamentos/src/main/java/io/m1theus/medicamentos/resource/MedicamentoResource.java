package io.m1theus.medicamentos.resource;

import io.m1theus.medicamentos.model.Medicamento;
import io.m1theus.medicamentos.service.MedicamentoService;
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

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoResource {

    private final MedicamentoService service;

    public MedicamentoResource(MedicamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> findById(@PathVariable("id") final String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Medicamento> save(@RequestBody final Medicamento medicamento) {
        return ResponseEntity.ok(service.save(medicamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> update(@PathVariable("id") final String id,
                                              @RequestBody final Medicamento medicamento) {
        return ResponseEntity.ok(service.update(id, medicamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
