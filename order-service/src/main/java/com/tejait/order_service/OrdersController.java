package com.tejait.order_service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("orders")
public class OrdersController {

    OrdersService service;

    @PostMapping("placeOrder")
    public ResponseEntity<Orders> placeOrder(@RequestBody OrdersRequest request){

        com.tejait.order_service.Orders savedOrder =service.placeOrder(request);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
