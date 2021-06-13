package br.edu.logatti.service;

import br.edu.logatti.model.JobFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileConsumer {
    private final StorageService storageService;

    public FileConsumer(final StorageService storageService) {
        this.storageService = storageService;
    }

    @RabbitListener(queues = {"${app.file.queue}"})
    public void listen(@Payload JobFile file) {
        log.info("c=FileConsumer m=listen file={}", file);
        storageService.store(file);
    }
}
