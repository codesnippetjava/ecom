package com.codesnippet.ecom.Service;

import org.springframework.stereotype.Service;

@Service
public class CreditCardService implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card Payment Processing");
    }
}
