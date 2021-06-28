package com.restaurant.reservationApp.Payment;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PaymentRepositoryImpl implements PaymentRepository {
    List<Payment> list = new ArrayList<>();

    public PaymentRepositoryImpl() {
        Payment payment = new Payment();
        payment.setId(1);
        payment.setPaymentMethod("cash");
        payment.setTotalPrice(20.20);
        list.add(payment);
    }

    @Override
    public List<Payment> getAllPayment() {
        return list;
    }

    @Override
    public Payment getPaymentById(long id) {
        Optional<Payment> payment1 = list.stream().filter(payment -> payment.getId() == id).findFirst();
        return payment1.get();
    }

    @Override
    public Payment createPayment(Payment payment) {
        payment.setId(list.size()+1);
        list.add(payment);
        return payment;
    }
}