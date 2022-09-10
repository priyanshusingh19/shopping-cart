package com.example.products.service;

import com.example.products.exception.productAlreadyExistException;
import com.example.products.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public void deleteProduct(String id);
    Product update(Product product);
    Optional<Product> findById(String id);
    public ResponseEntity<?> addProduct(Product product) throws productAlreadyExistException;
    public ResponseEntity<?> getProducts();

    List<Product> findAll();
}
