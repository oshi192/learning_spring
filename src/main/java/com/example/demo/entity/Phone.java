package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Phone {

    @Id
    @GeneratedValue
    @Column( nullable = false)
    private Long id;

    @Column ( nullable = false, length = 32)
    private String number;

    @ManyToOne(fetch =  FetchType.LAZY, optional =  false)
    @JoinColumn(name = "person_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Person person;
}
