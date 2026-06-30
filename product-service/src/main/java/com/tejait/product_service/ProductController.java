package com.tejait.product_service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("product")
public class ProductController {

    ProductService service;

    @PostMapping("saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct =service.saveProduct(product);
        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id){
       Product product =service.getById(id);
       return new ResponseEntity<>(product,HttpStatus.OK);
    }

   @PutMapping("updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updatedProduct=service.saveProduct(product);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        String str=service.deleteProduct(id);
        return new ResponseEntity<>(str,HttpStatus.OK);
    }
}
