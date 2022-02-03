package com.example.orderservice.api.controller;

import com.example.orderservice.api.common.Payment;
import com.example.orderservice.api.common.TransactionRequest;
import com.example.orderservice.api.common.TransactionResponse;
import com.example.orderservice.api.entity.Order;
import com.example.orderservice.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        return service.saveOrder(request);
        //do a rest call to payment and pass order id
    }
}
