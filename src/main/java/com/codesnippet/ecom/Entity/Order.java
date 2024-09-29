package com.codesnippet.ecom.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Past(message =
            "Order date must be in the past")
    private LocalDate orderDate;

    @PastOrPresent(message =
            "Payment date must be in the past or present")
    private LocalDate paymentDate;

    @Future(message =
            "Delivery date must be in the future")
    private LocalDate deliveryDate;

    @FutureOrPresent(message =
            "Shipment date must be in the present or future")
    private LocalDate shipmentDate;

    @Email(message = "Customer email should be valid")
    private String customerEmail;

    @Pattern(regexp = "^[A-Za-z0-9]+$",
            message = "Order reference must be alphanumeric")
    private String orderReference;

    @AssertTrue(message = "Order must be confirmed")
    private Boolean confirmed;

    public Order() {}

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference( String orderReference) {
        this.orderReference = orderReference;
    }

    public  Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed( Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public @Email(message = "Customer email should be valid") String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(@Email(message = "Customer email should be valid") String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Order(LocalDate orderDate, LocalDate paymentDate, LocalDate deliveryDate, LocalDate shipmentDate) {
        this.orderDate = orderDate;
        this.paymentDate = paymentDate;
        this.deliveryDate = deliveryDate;
        this.shipmentDate = shipmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDate shipmentDate) {
        this.shipmentDate = shipmentDate;
    }
}
