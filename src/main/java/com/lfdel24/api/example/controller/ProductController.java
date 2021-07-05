package com.lfdel24.api.example.controller;

import com.lfdel24.api.example.dto.Message;
import com.lfdel24.api.example.entity.Product;
import com.lfdel24.api.example.repository.ProductRepository;
import java.util.ArrayList;
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
@RequestMapping(path = "api/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping()
    public ResponseEntity<List<Product>> list() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    private List<Message> getListMessage(Product p) {
        List<Message> list = new ArrayList<>();
        if (p.getName().isEmpty()) {
            list.add(new Message("Name is required"));
        }
        if (p.getDetail().isEmpty()) {
            list.add(new Message("Detail is required"));
        }
        if (p.getPrice() <= 0) {
            list.add(new Message("Price is required"));
        }
        return list;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody Product product) {
        List listMessage = getListMessage(product);
        if (listMessage.isEmpty()) {
            repository.save(product);
            return new ResponseEntity<>(new Message("Product created", product), HttpStatus.OK);
        }
        return new ResponseEntity<>(listMessage, HttpStatus.OK);

    }

}
