package com.andremapa.productregistration.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource not found for the given id : " + id);
    }
}
