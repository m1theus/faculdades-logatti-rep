package br.edu.logatti.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CoreConfig {
    @Value("${app.file.queue}")
    private String fileQueue;

    @Bean
    public Queue queue() {
        return new Queue(fileQueue, true);
    }
}
