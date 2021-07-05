package com.lfdel24.api.example.repository;

import com.lfdel24.api.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author leo
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
