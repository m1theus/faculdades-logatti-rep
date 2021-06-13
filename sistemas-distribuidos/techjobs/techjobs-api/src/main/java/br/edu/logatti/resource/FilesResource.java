package br.edu.logatti.resource;

import br.edu.logatti.exception.InvalidFileException;
import br.edu.logatti.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FilesResource {
    private final StorageService service;

    public FilesResource(final StorageService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> handleFileUpload(@RequestParam("file") final MultipartFile file) {
        service.store(file);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(value = InvalidFileException.class)
    public ResponseEntity<String> handlerException(final InvalidFileException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handlerException() {
        return ResponseEntity.badRequest().body("failed to upload file!");
    }
}
