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

        //We have now received the product id and the amount to be paid for the products
        orders.setProductId(request.getProductId());
        orders.setAmount(request.getAmount());

        //Connecting to the product database so that to check the availability of the product
        //In the product database by hitting the URI mentioned below
        Product product=webClient.get()
                                  .uri("http://localhost:8080/product/getById/"+request.getProductId())
                .retrieve()
                .bodyToMono(Product.class)
                .block();

        //After retival the product if present then getting the name of the product and updating the
        //Order Status of the product
        orders.setProductName(product.getName());
        orders.setOrderStatus("CREATED");
        repository.save(orders);
        //Checking the quantity present in the inventory or not using the inventory URI
        Boolean result=webClient.get()
                .uri("http://localhost:8083/inventory/availability/"+request.getProductId()+"/"+request.getQuantity())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if(!result){ // If order failed Then we have to set the status failed and update
            // the repository with failed order status
            orders.setOrderStatus("FAILED");
            return repository.save(orders);//Saving the failed order into the repository
        }

        //Sending the payment request to the payment service
        webClient.post()
                .uri("http://localhost:8084/payments/makePayment")
                .bodyValue(new PaymentRequest(orders.getId(),orders.getAmount()))
                .retrieve()
                .toBodilessEntity();

        //Sending the notification req to the notification service
        webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("http://localhost:8085/notification/sendNotification")
                        .queryParam("message", "Order Placed Successfully")
                        .build())
                .retrieve()
                .toBodilessEntity();

        orders.setOrderStatus("SUCCESS");

        return repository.save(orders);
    }
}
