package com.jpa.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem {

    @Id @GeneratedValue
    @Column (name = "order_item_id")
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name="order_id")
    private Order order;

    private Long itemId;
    private Long orderId;

    private int orderPrice;
    private int count;

}
