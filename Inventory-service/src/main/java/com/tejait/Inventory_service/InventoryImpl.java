package com.tejait.Inventory_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InventoryImpl {

    InventoryRepository repository;

    public Inventory saveInventory(Inventory inventory) {
        return repository.save(inventory);
    }

    public Inventory checkAvailability(Integer productId, Integer requestQty) {
        return repository.findByProductId(productId);
    }
}
