package br.edu.logatti.projetorevisao.repository;

import br.edu.logatti.projetorevisao.entity.Modulo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModuloRepository extends MongoRepository<Modulo, String> {
}
