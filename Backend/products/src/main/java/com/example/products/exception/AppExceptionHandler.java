package com.example.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(productAlreadyExistException.class)
    public ResponseEntity<String> handleAlreadyExistException(productAlreadyExistException exception){
        return new ResponseEntity<>(" already exists", HttpStatus.CONFLICT);

    }
}
