package com.tejait.api_gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
    @GetMapping("/fallback/product")
    public ResponseEntity<String> productFallback(){
        return new ResponseEntity<>("Product Service has Issue please contact Teja IT: 7013781152", HttpStatus.SERVICE_UNAVAILABLE);
    }

    @GetMapping("/fallback/inventory")
    public ResponseEntity<String> inventoryFallback(){
        return new ResponseEntity<>("Inventory Service has Issue please contact Teja IT: 7013781152", HttpStatus.SERVICE_UNAVAILABLE);
    }
    @GetMapping("/fallback/payment")
    public ResponseEntity<String> paymentFallback(){
        return new ResponseEntity<>("Payment Service has Issue please contact Teja IT: 7013781152", HttpStatus.SERVICE_UNAVAILABLE);
    }
    @GetMapping("/fallback/notification")
    public ResponseEntity<String> notificationFallback(){
        return new ResponseEntity<>("Notification Service has Issue please contact Teja IT: 7013781152", HttpStatus.SERVICE_UNAVAILABLE);
    }
    @GetMapping("/fallback/order")
    public ResponseEntity<String> ordersFallback(){
        return new ResponseEntity<>("Orders Service has Issue please contact Teja IT: 7013781152", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
