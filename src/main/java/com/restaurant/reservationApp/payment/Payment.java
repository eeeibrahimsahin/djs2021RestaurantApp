package com.restaurant.reservationApp.payment;

public class Payment {
        private long id;
        private String paymentMethod;
        private double totalPrice;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPaymentMethod() { return paymentMethod; }

    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
