package br.edu.logatti.urbantransport.resource.linha;

import br.edu.logatti.urbantransport.entity.Linha;
import br.edu.logatti.urbantransport.service.LinhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/linha")
public class LinhaResource {
    private final LinhaService service;

    @PostMapping
    protected ResponseEntity<Linha> save(@RequestBody Linha linha) {
        return ResponseEntity.ok(service.save(linha));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<Linha> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
