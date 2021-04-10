package io.m1theus.medicamentos.resource.handler;

import io.m1theus.medicamentos.exception.ResourceNotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
@ControllerAdvice
public class ExceptionHandlerResource {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNotFoundException(final Exception ex) {
        final var apiError =
                new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(final Exception ex) {
        final var apiError =
                new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
