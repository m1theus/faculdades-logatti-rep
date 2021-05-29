package br.edu.logatti.avaliacaoredis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
    public static final String AVALIACAO_CACHE = "AVALIACAO";
}
