package br.edu.logatti.service;

import br.edu.logatti.entity.JobEntity;
import br.edu.logatti.entity.JobFile;
import br.edu.logatti.exception.InvalidFileException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StorageService {
    private static final List<String> ACCEPTED_FILE_TYPE = List.of("csv", "xlsx");
    private final JobsService jobsService;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public StorageService(
            JobsService jobsService, final RabbitTemplate rabbitTemplate,
            final Queue queue
    ) {
        this.jobsService = jobsService;
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @SneakyThrows
    public void store(final MultipartFile file) {
        log.info("c=StorageService m=store m=store file={}", file.getOriginalFilename());
        validateFile(file);
        enqueueingFile(new JobFile(file));
    }

    public void store(final JobFile file) {
        final List<JobEntity> jobEntities = readJobsFromCsv(file.getFileContent());
        jobsService.saveAll(jobEntities);
    }

    private void enqueueingFile(final JobFile file) {
        log.info("c=StorageService m=store action=enqueueing file={}", file.getFileName());
        rabbitTemplate.convertAndSend(queue.getName(), file);
    }

    private void validateFile(final MultipartFile file) throws InvalidFileException {
        if (file == null) {
            throw new InvalidFileException("file must be not null");
        }

        if (file.isEmpty()) {
            throw new InvalidFileException("file must be not empty");
        }

        if (!ACCEPTED_FILE_TYPE.contains(JobFile.fileExtension(file))) {
            throw new InvalidFileException("unsupported file type");
        }
    }

    private static List<JobEntity> readJobsFromCsv(InputStream file) {
        List<JobEntity> jobs = new ArrayList<>();

        try (var br = new BufferedReader(new InputStreamReader(file))) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                var job = createJobEntity(attributes);
                jobs.add(job);
                line = br.readLine();
            }

        } catch (final IOException e) {
            throw new InvalidFileException();
        }

        return jobs;
    }

    private static JobEntity createJobEntity(final String[] metadata) {
        var nomeVaga = metadata[0];
        var cargoVaga = metadata[1];
        var techVaga = metadata[2];
        var obsVaga = metadata[3];
        return new JobEntity(nomeVaga, cargoVaga, techVaga, obsVaga);
    }
}
