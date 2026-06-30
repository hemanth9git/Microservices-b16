package com.tejait.Inventory_service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("inventory")
public class InventoryController {

    InventoryImpl service;

    @PostMapping("saveInventory")
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory){
       Inventory savedInventory =service.saveInventory(inventory);
       return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
    }

    @GetMapping("/availability/{productId}/{requestQty}")
    public Boolean checkAvailability(@PathVariable Integer productId,@PathVariable Integer requestQty){
        Inventory inventory=service.checkAvailability(productId,requestQty);
        return inventory.getStockQty() >= requestQty ;
    }

}
