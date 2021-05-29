package br.edu.logatti.avaliacaoredis.resource;

import br.edu.logatti.avaliacaoredis.entity.Avaliacao;
import br.edu.logatti.avaliacaoredis.service.AvaliacaoService;
import br.edu.logatti.avaliacaoredis.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/avaliacao")
public class AvaliacaoResource {
    private final AvaliacaoService service;
    private final CacheService cacheService;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> findById(
            @PathVariable final String id,
            @RequestParam(name = "evictCache", required = false, defaultValue = "false") final boolean evictCache) {

        if (evictCache) {
            cacheService.evict(id);
        }

        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Avaliacao> save(@RequestBody final Avaliacao avaliacao) {
        return ResponseEntity.status(CREATED).body(service.save(avaliacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable final String id, @RequestBody final Avaliacao avaliacao) {
        final Avaliacao entity = service.update(id, avaliacao);
        cacheService.evict(entity.getId());
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Avaliacao> delete(@PathVariable final String id) {
        service.delete(id);
        cacheService.evict(id);
        return ResponseEntity.ok().build();
    }

}
