package br.edu.logatti.avaliacaoredis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static br.edu.logatti.avaliacaoredis.config.CacheConfig.AVALIACAO_CACHE;

@Component
@RequiredArgsConstructor
public class CacheService {
    private final CacheManager cacheManager;

    public void evict(final String id) {
        evict(AVALIACAO_CACHE, id);
    }

    private void evict(final String cacheName, final String id) {
        Optional.ofNullable(cacheManager.getCache(cacheName))
                .ifPresent(cache -> cache.evict(id));
    }

}
