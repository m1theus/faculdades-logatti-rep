package br.edu.logatti.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("resource not found!");
    }
}
