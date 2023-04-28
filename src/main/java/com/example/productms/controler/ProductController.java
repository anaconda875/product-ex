package com.example.productms.controler;

import com.example.productms.data.domain.CustomPageRequest;
import com.example.productms.dto.request.ProductRequest;
import com.example.productms.dto.response.ProductResponse;
import com.example.productms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1/products")
public class ProductController {
  
  protected final ProductService productService;
  
  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }
  
  @GetMapping
  public Page<ProductResponse> findAll(CustomPageRequest pageable) {
    return productService.findAll(pageable);
  }
  
  @GetMapping("/{id}")
  public ProductResponse findById(Long id) {
//    return productService.findById(id);
  }
  
  @PostMapping
  public ProductResponse create(@RequestBody ProductRequest productRequest) {
    return productService.create(productRequest);
  }
  
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    productService.deleteById(id);
  }
  
  @PutMapping("/{id}")
  public ProductResponse update(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
//    return productService.update(id, productRequest);
  }
  
}
