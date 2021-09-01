package com.restaurant.reservationApp.payment;

import com.restaurant.reservationApp.order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String paymentMethod;
    @OneToOne
    private Order order;
    private double totalPrice;
}
