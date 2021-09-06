package com.restaurant.reservationApp.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PaymentController {
    PaymentService paymentService;

    private Payment paymentWhichIsProcessing;

    public PaymentController() {
    }

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public ResponseEntity<List<Payment>> getAllPayment() {
        List<Payment> allPayment = paymentService.getAllPayment();
        return new ResponseEntity<>(allPayment, HttpStatus.OK);
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable(name = "id", required = true) long id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        if (payment.isPresent())
            return new ResponseEntity<>(payment.get(), HttpStatus.OK);
        return null;
    }

    @PutMapping(value = "/payment", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment payment1 = paymentService.createPayment(payment);
        return new ResponseEntity<>(payment1, HttpStatus.OK);
    }

    @PostMapping("/payment")
    public void setPaymentInfo(@RequestBody Payment payment) {
        paymentWhichIsProcessing = payment;
    }

    @GetMapping("/payment/in/processing")
    public ResponseEntity<Payment> getPaymentInProcessing(){
        return new ResponseEntity<>(paymentWhichIsProcessing,HttpStatus.OK);
    }
}
