package br.edu.logatti.urbantransport.repository;

import br.edu.logatti.urbantransport.entity.Linha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinhaRepository extends JpaRepository<Linha, Long> {
}
