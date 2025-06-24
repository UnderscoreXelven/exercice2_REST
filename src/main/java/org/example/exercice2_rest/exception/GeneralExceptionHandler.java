package org.example.exercice2_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> notFoundHandler (NotFoundException ex){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Element Not found");
  }

}
