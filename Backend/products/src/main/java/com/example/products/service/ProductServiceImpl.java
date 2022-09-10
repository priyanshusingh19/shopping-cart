package com.example.products.service;

import com.example.products.Repo.ProductRepo;
import com.example.products.exception.productAlreadyExistException;

import com.example.products.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product update(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        this.productRepo.deleteById(id);
    }

    @Override
    public ResponseEntity<?> addProduct(Product product) throws productAlreadyExistException {
        final Optional<Product> productOptional = this.productRepo.findById(product.getId());
        if(productOptional.isPresent())
        {
            throw new productAlreadyExistException("Product already Existed");
        }
        Product save=  this.productRepo.save(product);
        return ResponseEntity.of(this.productRepo.findById(product.getId()));
    }

    @Override
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(this.productRepo.findAll());
    }

    @Override
    public Optional<Product> findById(String id) {
return this.productRepo.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepo.findAll();
    }
}
