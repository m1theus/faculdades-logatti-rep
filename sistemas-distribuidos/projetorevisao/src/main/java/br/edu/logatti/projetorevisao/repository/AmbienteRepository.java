package br.edu.logatti.projetorevisao.repository;

import br.edu.logatti.projetorevisao.entity.Ambiente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AmbienteRepository extends MongoRepository<Ambiente, String> {
}
