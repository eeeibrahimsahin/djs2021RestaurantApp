package com.restaurant.reservationApp.payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> getAllPayment();

    Optional<Payment> getPaymentById(long id);

    Payment createPayment(Payment payment);

    void saveAllPayment(List<Payment> paymentList);
}

