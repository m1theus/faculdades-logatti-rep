package br.edu.logatti.repository;

import br.edu.logatti.entity.JobEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JobsRepository extends MongoRepository<JobEntity, String> {
    Optional<JobEntity> findByNomeVagaLike(String name);
}
