package com.jpa.demo.entity.solution;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Teacher {

    @Id @GeneratedValue
    private Long id;

    private String name;

    public Teacher(String name) {
        this.name = name;
    }
}
