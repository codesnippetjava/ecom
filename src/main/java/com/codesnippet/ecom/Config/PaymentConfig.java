package com.codesnippet.ecom.Config;

import com.codesnippet.ecom.Service.CreditCardService;
import com.codesnippet.ecom.Service.GPayService;
import com.codesnippet.ecom.Service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

   // @Bean
    public PaymentService creditCardPaymentService(){
        return new CreditCardService();
    }
    //@Bean
    public PaymentService gpayPaymentService(){
        return new GPayService();
    }
}
