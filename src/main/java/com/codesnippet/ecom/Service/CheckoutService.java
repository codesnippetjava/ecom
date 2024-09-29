package com.codesnippet.ecom.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final PaymentService paymentService;
    @Autowired
    public CheckoutService(@Qualifier("GPayService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    public void checkoutOrder(double amount){
        paymentService.processPayment(amount);
        System.out.println("checkout order for amount "+ amount);
    }
}
