package com.tejait.order_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class OrdersService {

    OrdersRepository repository;

    WebClient webClient;

    public Orders placeOrder(OrdersRequest request) {

        Orders orders=new Orders();

        orders.setProductId(request.getProductId());
        orders.setAmount(request.getAmount());

        Product product=webClient.get()
                                  .uri("http://localhost:8080/product/getById/"+request.getProductId())
                .retrieve()
                .bodyToMono(Product.class)
                .block();

        orders.setProductName(product.getName());
        orders.setOrderStatus("CREATED");
        repository.save(orders);

        return null;
    }
}
