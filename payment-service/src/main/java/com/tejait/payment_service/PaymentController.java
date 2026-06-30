package com.tejait.payment_service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("payments")
public class PaymentController {

    PaymentsRepository repository;

    @PostMapping("makePayment")
    public ResponseEntity<Payment> paymentStatus(@RequestBody PaymentRequest request){

        Payment payment= new Payment();
        payment.setOrderId(request.getOrderId());
        payment.setAmount(request.getAmount());
        payment.setPaymentStatus("Success");

        return new ResponseEntity<>(repository.save(payment), HttpStatus.OK);
    }

}
