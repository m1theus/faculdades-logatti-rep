package br.edu.logatti.urbantransport.repository;

import br.edu.logatti.urbantransport.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String> {
}
