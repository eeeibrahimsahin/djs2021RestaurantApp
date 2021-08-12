package com.restaurant.reservationApp.payment;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends CrudRepository<Payment,Long> {
//    public List<Payment> getAllPayment();
//    public Payment getPaymentById(long id);
//    public Payment createPayment(Payment payment);
}
