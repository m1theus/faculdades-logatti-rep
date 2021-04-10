package io.m1theus.medicamentos.repository;

import io.m1theus.medicamentos.model.Medicamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends MongoRepository<Medicamento, String> {
}
