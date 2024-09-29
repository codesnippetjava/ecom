package com.codesnippet.ecom.Service;

import org.springframework.stereotype.Service;

@Service
public class GPayService implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("Gpay Payment processing");
    }
}
