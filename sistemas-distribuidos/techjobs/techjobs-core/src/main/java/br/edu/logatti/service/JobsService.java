package br.edu.logatti.service;

import br.edu.logatti.entity.JobDTO;
import br.edu.logatti.entity.JobEntity;
import br.edu.logatti.exception.ResourceNotFoundException;
import br.edu.logatti.repository.JobsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JobsService {
    private final JobsRepository repository;

    public JobsService(final JobsRepository repository) {
        this.repository = repository;
    }

    @Cacheable(
            value = "findAll",
            unless = "#result == null"
    )
    public List<JobDTO> findAll() {
        log.info("c=JobsService m=findAll");
        return repository.findAll()
                .stream()
                .map(JobEntity::toDTO)
                .collect(Collectors.toList());
    }

    @Cacheable(
            value = "findById",
            key = "#id",
            unless = "#result == null"
    )
    public JobDTO findById(final String id) {
        log.info("c=JobsService m=findById id={}", id);
        return repository.findById(id)
                .map(JobEntity::toDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Cacheable(
            value = "queryByName",
            key = "#name",
            unless = "#result == null"
    )
    public JobDTO queryByName(final String name) {
        log.info("c=JobsService m=queryByName name={}", name);
        return repository.findByNomeVagaLike(name)
                .map(JobEntity::toDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void saveAll(final List<JobEntity> entities) {
        log.info("c=JobsService m=saveAll entities={}", entities);
        repository.saveAll(entities);
    }
}
