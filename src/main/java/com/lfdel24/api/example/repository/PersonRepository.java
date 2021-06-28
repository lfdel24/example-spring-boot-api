package com.lfdel24.api.example.repository;

import com.lfdel24.api.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author leo
 */
public abstract class PersonRepository implements JpaRepository<Product, Long>{
    
}
