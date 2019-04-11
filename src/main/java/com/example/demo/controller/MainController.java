package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.exceptions.PersonNotFoundEcxeption;
import com.example.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MainController {
@Autowired
    PersonRepository personRepository;

    @GetMapping("/persons")
    List<Person> getAll(){
        return personRepository.findAll();
    }
    @GetMapping("/persons/{id}")
    Person getOne(@PathVariable Long id){
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundEcxeption(id));
    }

    @PostMapping("/persons")
    Person saveToH2Db(@RequestBody Person p){
        return personRepository.save(p);
    }

    @PutMapping("/persons/{id}")
    Person replacePerson(@RequestBody Person p,@PathVariable Long id){
        return personRepository.findById(id)
                .map(person -> {
                    person.setAge(p.getAge());
                    person.setName(p.getName());
                    return personRepository.save(person);
                }).orElseGet(() -> {
                    p.setId(id);
                    return personRepository.save(p);
                });
    }

    @GetMapping("/persons/find*")
    List<Person> findByAge(@RequestParam String age){
        if(age!=null && age.matches("[0-9]*"))return personRepository.findByAge(Integer.parseInt(age));
        throw new PersonNotFoundEcxeption("invalid input parameter age:"+age);
    }
}
