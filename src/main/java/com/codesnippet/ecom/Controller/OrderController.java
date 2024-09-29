package com.codesnippet.ecom.Controller;

import com.codesnippet.ecom.Entity.ErrorResponse;
import com.codesnippet.ecom.Entity.Order;
import com.codesnippet.ecom.Entity.Product;
import com.codesnippet.ecom.exceptions.ProductNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class OrderController {

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<?> getBookById
            (@PathVariable("id") Integer orderId) {
        throw new ProductNotFoundException("Product for order is not found");
    }
    @PostMapping("/orders")
    public ResponseEntity<String> addOrder(@Valid @RequestBody Order order) {
         // Save order to the database
        return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
    }
}
