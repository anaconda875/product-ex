package com.example.productms.service;

import com.example.productms.data.domain.CustomPageRequest;
import com.example.productms.dto.request.OrderItem;
import com.example.productms.dto.request.OrderRequest;
import com.example.productms.dto.request.ProductRequest;
import com.example.productms.dto.response.OrderResponse;
import com.example.productms.dto.response.ProductResponse;
import com.example.productms.entity.Product;
import com.example.productms.exception.ResourceNotEnoughException;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public interface ProductService {
  ProductResponse create(ProductRequest productRequest);
  
  void deleteById(Long id);
  
  Page<ProductResponse> findAll(CustomPageRequest pageRequest);
  
  /**
   * validate product by id and quantity
   * @param id
   * @return product if validation passed, otherwise throw ResourceNotEnoughException
   */
  Product validateAndReturn(Long id, Integer quantity);
  
  void doCreateOrder(StreamBridge streamBridge, OrderRequest msg);
}
