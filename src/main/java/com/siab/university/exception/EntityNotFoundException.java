package com.siab.university.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entity) {
        super(entity + "with current ID wasn't found");
    }
}
