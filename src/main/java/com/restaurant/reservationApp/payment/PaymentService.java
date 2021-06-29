package com.restaurant.reservationApp.payment;

import java.util.List;

public interface PaymentService {
        public List<Payment> getAllPayment();
        public Payment getPaymentById(long id);
        public Payment createPayment(Payment payment);
    }

