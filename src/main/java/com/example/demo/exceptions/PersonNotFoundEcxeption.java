package com.example.demo.exceptions;

public class PersonNotFoundEcxeption extends RuntimeException{
    public PersonNotFoundEcxeption(Long id) {
        super("Could not find person with id: " + id);
    }
}
