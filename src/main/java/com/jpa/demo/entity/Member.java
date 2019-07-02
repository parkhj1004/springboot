package com.jpa.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany (mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    /** 연관관계 메소드 **/
    public void setOrder (Order order) {
        orders.add(order);
        order.setMember(this);
    }
}
