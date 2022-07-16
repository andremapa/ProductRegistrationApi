package com.andremapa.productregistration.handler;

import com.andremapa.productregistration.domain.error.InvalidFieldError;
import com.andremapa.productregistration.domain.error.NotFoundError;
import com.andremapa.productregistration.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;
import java.util.List;

import static java.util.stream.Collectors.toMap;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<NotFoundError> handlerResourceNotFoundException(ResourceNotFoundException e){
        NotFoundError notFoundError = new NotFoundError(LocalTime.now(), HttpStatus.NOT_FOUND, e.getClass().getTypeName(), e.getMessage());
        return new ResponseEntity<>(notFoundError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InvalidFieldError> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getFieldErrors();
        InvalidFieldError error = new InvalidFieldError(LocalTime.now(), HttpStatus.BAD_REQUEST, e.getClass().getTypeName(),
                fieldErrors.stream().collect(toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage
                )));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
