package com.jpa.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("A")
@Data
public class Album extends Item{

    private String artist;
    private String etc;
}
