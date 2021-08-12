package com.restaurant.reservationApp.payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
        public List<Payment> getAllPayment();
        public Optional<Payment> getPaymentById(long id);
        public Payment createPayment(Payment payment);
    }

