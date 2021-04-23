package br.edu.logatti.urbantransport.resource.empresa;

import br.edu.logatti.urbantransport.entity.Empresa;
import br.edu.logatti.urbantransport.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empresa")
public class EmpresaResource {

    private final EmpresaService service;

    @GetMapping("/{name}")
    protected ResponseEntity<Empresa> findByName(@PathVariable final String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping
    protected ResponseEntity<Empresa> save(@RequestBody Empresa empresa) {
        return ResponseEntity.ok(service.save(empresa));
    }

    @DeleteMapping("/{name}")
    protected ResponseEntity<Empresa> delete(@PathVariable final String name) {
        service.delete(name);
        return ResponseEntity.ok().build();
    }

}
