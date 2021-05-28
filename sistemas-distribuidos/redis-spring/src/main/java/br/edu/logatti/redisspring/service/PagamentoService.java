package br.edu.logatti.redisspring.service;

import br.edu.logatti.redisspring.config.CacheConfig;
import br.edu.logatti.redisspring.entity.Pagamento;
import br.edu.logatti.redisspring.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagamentoService {
    private final PagamentoRepository repository;

    @Cacheable(
            value = CacheConfig.PAGAMENTO_CACHE,
            key = "#id",
            unless = "#result == null"
    )
    public Optional<Pagamento> findById(final String id) {
        log.info("c=PagamentoService m=findById id={}", id);
        return repository.findById(id);
    }

    public Pagamento save(final Pagamento pagamento) {
        log.info("c=PagamentoService m=save entity={}", pagamento);
        return repository.save(pagamento);
    }
}
