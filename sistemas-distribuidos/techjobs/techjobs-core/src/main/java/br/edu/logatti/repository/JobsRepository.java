package br.edu.logatti.repository;

import br.edu.logatti.model.JobEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobsRepository extends MongoRepository<JobEntity, String> {
    List<JobEntity> findByNomeVagaContainingIgnoreCase(String name);
}
