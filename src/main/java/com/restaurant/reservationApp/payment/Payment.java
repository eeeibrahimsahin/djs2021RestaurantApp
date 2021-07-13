package com.restaurant.reservationApp.payment;

import com.restaurant.reservationApp.order.Order;

public class Payment {
        private long id;
        private String paymentMethod;
        private Order order;
        private double totalPrice;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPaymentMethod() { return paymentMethod; }

    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
