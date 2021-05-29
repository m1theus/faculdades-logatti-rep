package br.edu.logatti.avaliacaoredis.service;

import br.edu.logatti.avaliacaoredis.config.CacheConfig;
import br.edu.logatti.avaliacaoredis.entity.Avaliacao;
import br.edu.logatti.avaliacaoredis.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AvaliacaoService {
    private final AvaliacaoRepository repository;

    public List<Avaliacao> findAll() {
        return repository.findAll();
    }

    @Cacheable(
            value = CacheConfig.AVALIACAO_CACHE,
            key = "#id",
            unless = "#result == null"
    )
    public Optional<Avaliacao> findById(final String id) {
        log.info("c=AvaliacaoService m=findById id={}", id);
        return repository.findById(id);
    }

    public Avaliacao save(final Avaliacao avaliacao) {
        log.info("c=AvaliacaoService m=save entity={}", avaliacao);
        return repository.save(avaliacao);
    }

    public Avaliacao update(String id, final Avaliacao avaliacao) {
        final var entity = findById(id).orElseThrow();
        log.info("c=AvaliacaoService m=update request={}, entity={}", avaliacao, entity);
        entity.update(avaliacao);
        return repository.save(entity);
    }

    public void delete(final String id) {
        log.info("c=AvaliacaoService m=delete id={}", id);
        repository.deleteById(id);
    }
}
