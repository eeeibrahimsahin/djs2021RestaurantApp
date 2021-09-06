package com.restaurant.reservationApp.payment;

import com.restaurant.reservationApp.order.Order;
import com.restaurant.reservationApp.order.OrderRepository;
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
    OrderRepository orderRepository;

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
        Optional<Order> orderOptional = orderRepository.findById(payment.getOrder().getId());
        orderOptional.get().setPaid(true);
        orderRepository.save(orderOptional.get());
        return paymentRepository.save(payment);
    }

    @Override
    public void saveAllPayment(List<Payment> paymentList) {
        paymentList.forEach(payment -> createPayment(payment));
    }

    @Override
    public Payment calculateTotalPrice(Order order) {

        return null;
    }
}


