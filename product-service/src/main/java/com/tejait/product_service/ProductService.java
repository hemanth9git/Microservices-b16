package com.tejait.product_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class ProductService {

    ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product getById(Integer id) {
        return repository.findById(id).get();
    }

    public String deleteProduct(Integer id) {
        repository.deleteById(id);
        return "Product with id "+id+" deleted successfully";
    }
}
