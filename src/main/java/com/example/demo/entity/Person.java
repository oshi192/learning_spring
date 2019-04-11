package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    @Column( nullable = false)
    private Long id;
    @Column( nullable = false)
    private int age;
    @Column ( nullable = false, length = 32)
    private String name;
}
