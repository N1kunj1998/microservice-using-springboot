package com.example.paymentservice.api.service;

import com.example.paymentservice.api.entity.Payment;
import com.example.paymentservice.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
//        System.out.println(payment.getPaymentStatus());
        return repository.save(payment);
    }

    public String paymentProcessing() {
        // api should be 3rd party payment gateway()
        return new Random().nextBoolean() ? "success" : "failure";
    }
}
