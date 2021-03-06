package com.jpa.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="orders")
public class Order extends BaseEntity {

    @Id @GeneratedValue
    @Column (name = "order_id")
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne (fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn (name="delivery_id")
    private Delivery delivery;


    @Temporal (TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated (EnumType.STRING)
    private OrderStatus status;

    /** 연관관계 메소드 **/
    public void setMember(Member member) {
        if(this.member != null) {
            this.member.getOrders().remove(this);
        }

        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
