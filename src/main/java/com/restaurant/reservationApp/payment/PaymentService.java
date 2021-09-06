package com.restaurant.reservationApp.payment;

import com.restaurant.reservationApp.order.Order;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> getAllPayment();

    Optional<Payment> getPaymentById(long id);

    Payment createPayment(Payment payment);

    void saveAllPayment(List<Payment> paymentList);

    Payment calculateTotalPrice(Order order);
}

