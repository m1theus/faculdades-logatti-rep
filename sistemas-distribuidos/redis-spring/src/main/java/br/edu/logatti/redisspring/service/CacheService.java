package br.edu.logatti.redisspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.edu.logatti.redisspring.config.CacheConfig.PAGAMENTO_CACHE;

@Service
@RequiredArgsConstructor
public class CacheService {
    private final CacheManager cacheManager;

    public void evict(final String id) {
        evict(PAGAMENTO_CACHE, id);
    }

    private void evict(final String cacheName, final String id) {
        Optional.ofNullable(cacheManager.getCache(cacheName))
                .ifPresent(cache -> cache.evict(id));
    }
}
