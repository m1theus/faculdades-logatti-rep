package br.edu.logatti.urbantransport.resource.quadrohorario;

import br.edu.logatti.urbantransport.entity.QuadroHorario;
import br.edu.logatti.urbantransport.service.QuadroHorarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quadro-horario")
public class QuadroHorarioResource {
    private final QuadroHorarioService service;

    @PostMapping
    protected ResponseEntity<QuadroHorario> save(@RequestBody QuadroHorario quadroHorario) {
        return ResponseEntity.ok(service.save(quadroHorario));
    }
}
