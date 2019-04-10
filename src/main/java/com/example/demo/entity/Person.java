package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "Person")//todo chack without name
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "aGe", nullable = false)
    private int age;
    @Column (name = "name", nullable = false, length = 32)
    private String name;

}
