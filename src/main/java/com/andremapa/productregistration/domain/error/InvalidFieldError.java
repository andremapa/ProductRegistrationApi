package com.andremapa.productregistration.domain.error;

import org.springframework.http.HttpStatus;

import java.time.LocalTime;
import java.util.Map;

public class InvalidFieldError {

    private final LocalTime timestamp;
    private final HttpStatus status;
    private final String pathError;
    private final Map<String, String> fields;

    public InvalidFieldError(LocalTime timestamp, HttpStatus status, String pathError, Map<String, String> fields) {
        this.timestamp = timestamp;
        this.status = status;
        this.pathError = pathError;
        this.fields = fields;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getPathError() {
        return pathError;
    }

    public Map<String, String> getFields() {
        return fields;
    }
}
