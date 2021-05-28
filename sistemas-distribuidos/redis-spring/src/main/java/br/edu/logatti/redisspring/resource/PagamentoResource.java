package br.edu.logatti.redisspring.resource;

import br.edu.logatti.redisspring.entity.Pagamento;
import br.edu.logatti.redisspring.service.CacheService;
import br.edu.logatti.redisspring.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PagamentoResource {
    private final PagamentoService service;
    private final CacheService cacheService;

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> findPayment(@PathVariable final String id,
                                                 @RequestParam(name = "evictCache", required = false, defaultValue = "false") final boolean evictCache) {
        if (evictCache) {
            cacheService.evict(id);
        }

        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pagamento> save(@RequestBody Pagamento pagamento) {
        return ResponseEntity.status(CREATED).body(service.save(pagamento));
    }
}
