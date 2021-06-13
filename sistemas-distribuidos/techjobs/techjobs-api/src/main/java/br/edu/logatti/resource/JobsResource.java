package br.edu.logatti.resource;

import br.edu.logatti.entity.JobDTO;
import br.edu.logatti.exception.ResourceNotFoundException;
import br.edu.logatti.service.JobsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsResource {
    private final JobsService service;

    public JobsResource(final JobsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> findById(@PathVariable final String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<JobDTO> queryByName(@RequestParam final String name) {
        return ResponseEntity.ok(service.queryByName(name));
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<String> handleException() {
        return ResponseEntity.notFound().build();
    }
}
