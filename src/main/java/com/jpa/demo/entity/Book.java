package com.jpa.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("B")
@Data
public class Book extends Item{

    private String author;
    private String isbn;
}
