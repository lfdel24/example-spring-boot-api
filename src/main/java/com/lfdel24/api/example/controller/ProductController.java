package com.lfdel24.api.example.controller;

import com.lfdel24.api.example.dto.Message;
import com.lfdel24.api.example.model.Product;
import com.lfdel24.api.example.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author leo
 */
@RestController
@RequestMapping(path = "api/v1/products/")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping(path = "list")
    public ResponseEntity<List<Product>> list() {
        return new ResponseEntity<List<Product>>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "create")
    public ResponseEntity<?> create(@RequestBody Product p) {
    if(p.getName().isEmpty()){
        return new ResponseEntity(new Message("Name is required"), HttpStatus.BAD_REQUEST);
    }
    repository.save(p);
    return new ResponseEntity<>(new Message("Product created"),HttpStatus.OK);
    
    }
    
    
}
