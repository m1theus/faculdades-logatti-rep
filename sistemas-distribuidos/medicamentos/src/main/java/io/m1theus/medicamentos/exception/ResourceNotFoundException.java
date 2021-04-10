package io.m1theus.medicamentos.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Recurso não encontrado.");
    }
}
