package com.andremapa.productregistration.domain.error;

import org.springframework.http.HttpStatus;

import java.time.LocalTime;

public class NotFoundError {
    private final LocalTime timestamp;
    private final HttpStatus status;
    private final String pathError;
    private final String message;

    public NotFoundError(LocalTime timestamp, HttpStatus status, String pathError, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.pathError = pathError;
        this.message = message;
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

    public String getMessage() {
        return message;
    }
}
