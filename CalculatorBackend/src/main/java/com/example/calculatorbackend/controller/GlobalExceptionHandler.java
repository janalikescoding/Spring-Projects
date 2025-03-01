package com.example.calculatorbackend.controller;

import com.example.calculatorbackend.exception.IncorrectOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(IncorrectOperationException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public ResponseEntity<Object> handleException(IncorrectOperationException ex){
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
  }
}
