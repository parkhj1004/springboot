package com.jpa.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Delivery {

    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;
//    private String city;
//    private String street;
//    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
