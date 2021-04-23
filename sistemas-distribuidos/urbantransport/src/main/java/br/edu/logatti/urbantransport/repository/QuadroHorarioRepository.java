package br.edu.logatti.urbantransport.repository;

import br.edu.logatti.urbantransport.entity.QuadroHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadroHorarioRepository extends JpaRepository<QuadroHorario, Long> {
}
