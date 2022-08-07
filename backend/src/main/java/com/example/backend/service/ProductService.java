package com.example.backend.service;

import com.example.backend.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void save(Product product);
}
