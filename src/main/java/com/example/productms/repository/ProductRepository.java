package com.example.productms.repository;

import com.example.productms.data.domain.CustomPageRequest;
import com.example.productms.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
  @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
  Page<Product> findAll(String keyword, CustomPageRequest pageRequest);
  
}
