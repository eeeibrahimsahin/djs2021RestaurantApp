package com.restaurant.reservationApp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Payment> payments = new ArrayList<>();
        Iterable<Payment> paymentIterable = paymentRepository.findAll();
        paymentIterable.forEach(payments::add);
        return payments;
    }

    @Override
    public Optional<Payment> getPaymentById(long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}


