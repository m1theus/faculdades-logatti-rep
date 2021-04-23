package br.edu.logatti.urbantransport.resource.itinerario;

import br.edu.logatti.urbantransport.entity.Itinerario;
import br.edu.logatti.urbantransport.service.ItinerarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/itinerario")
public class ItinerarioResource {

    private final ItinerarioService service;

    @PostMapping
    protected ResponseEntity<Itinerario> save(@RequestBody Itinerario itinerario) {
        return ResponseEntity.ok(service.save(itinerario));
    }

    @GetMapping("/{name}")
    protected ResponseEntity<Itinerario> findByName(@PathVariable final String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @DeleteMapping("/{name}")
    protected ResponseEntity<Itinerario> delete(@PathVariable final String name) {
        service.delete(name);
        return ResponseEntity.ok().build();
    }

}
