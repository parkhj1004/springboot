package com.jpa.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
@EqualsAndHashCode
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
