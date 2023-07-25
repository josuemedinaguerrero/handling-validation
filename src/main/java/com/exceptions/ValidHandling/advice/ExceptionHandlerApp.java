package com.exceptions.ValidHandling.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerApp {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleExceptionValidator(MethodArgumentNotValidException exception) {
    Map<String, String> errorMap = new HashMap<>();
    exception.getBindingResult().getFieldErrors().forEach(error -> {
      errorMap.put(error.getField(), error.getDefaultMessage());
    });
    return errorMap;
  }

}
