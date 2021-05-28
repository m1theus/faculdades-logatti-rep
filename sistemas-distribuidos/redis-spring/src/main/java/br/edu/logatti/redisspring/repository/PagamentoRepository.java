package br.edu.logatti.redisspring.repository;

import br.edu.logatti.redisspring.entity.Pagamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagamentoRepository extends MongoRepository<Pagamento, String> {
}
