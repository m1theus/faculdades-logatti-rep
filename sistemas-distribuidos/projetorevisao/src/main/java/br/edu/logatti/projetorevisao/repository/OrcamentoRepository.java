package br.edu.logatti.projetorevisao.repository;

import br.edu.logatti.projetorevisao.entity.Orcamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrcamentoRepository extends MongoRepository<Orcamento, String> {
}
