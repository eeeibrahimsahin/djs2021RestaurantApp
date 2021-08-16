package com.restaurant.reservationApp.payment;

import com.restaurant.reservationApp.db.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    SequenceGeneratorService sequenceGenerator;

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
        payment.setId(sequenceGenerator.generateSequence(Payment.SEQUENCE_NAME));
        return paymentRepository.save(payment);
    }

    @Override
    public void saveAllPayment(List<Payment> paymentList) {
        paymentList.forEach(payment -> createPayment(payment));
    }
}


