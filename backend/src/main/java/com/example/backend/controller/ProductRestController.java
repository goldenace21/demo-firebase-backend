package com.example.backend.controller;

import com.example.backend.model.Product;
import com.example.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Product>> getListTicket() {
        List<Product> productList = productService.getAll();
        if (productList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createCustomer(@RequestBody Product product) {
        this.productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
