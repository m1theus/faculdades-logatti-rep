package br.edu.logatti.projetorevisao.repository;

import br.edu.logatti.projetorevisao.entity.Squad;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SquadRepository extends MongoRepository<Squad, String> {
}
