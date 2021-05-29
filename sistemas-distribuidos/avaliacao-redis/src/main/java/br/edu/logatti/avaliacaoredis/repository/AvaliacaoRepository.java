package br.edu.logatti.avaliacaoredis.repository;

import br.edu.logatti.avaliacaoredis.entity.Avaliacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String> {
}
