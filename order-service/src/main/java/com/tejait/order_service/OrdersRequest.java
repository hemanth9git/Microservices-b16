package com.tejait.order_service;

import lombok.Data;

@Data
public class OrdersRequest {
    private int productId;
    private int amount;
    private int quantity;
}
