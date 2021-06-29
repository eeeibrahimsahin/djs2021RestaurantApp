package com.restaurant.reservationApp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class PaymentServiceImpl implements PaymentService {
        PaymentRepository paymentRepository;

        public PaymentServiceImpl() {
        }

        @Autowired
        public PaymentServiceImpl(PaymentRepository paymentRepository) {
            this.paymentRepository = paymentRepository;
        }

        @Override
        public List<Payment> getAllPayment() {

            return paymentRepository.getAllPayment();
        }

        @Override
        public Payment getPaymentById(long id) {
            return paymentRepository.getPaymentById(id);
        }

        @Override
        public Payment createPayment(Payment payment) {
            return paymentRepository.createPayment(payment);
        }
    }


