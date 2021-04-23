package br.edu.logatti.urbantransport.repository;

import br.edu.logatti.urbantransport.entity.Itinerario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario, String> {
}
