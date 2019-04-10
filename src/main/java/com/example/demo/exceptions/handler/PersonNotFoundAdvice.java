package com.example.demo.exceptions.handler;

import com.example.demo.exceptions.PersonNotFoundEcxeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PersonNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PersonNotFoundEcxeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String personNotFoundHandler(PersonNotFoundEcxeption ex) {
        return ex.getMessage();
    }
}
