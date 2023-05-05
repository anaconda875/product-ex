package com.example.productms.service;

import com.example.productms.data.domain.CustomPageRequest;
import com.example.productms.dto.request.CategoryRequest;
import com.example.productms.dto.request.ProductRequest;
import com.example.productms.dto.response.CategoryResponse;
import com.example.productms.dto.response.ProductResponse;
import com.example.productms.entity.Category;
import com.example.productms.entity.Product;
import com.example.productms.exception.ResourceNotEnoughException;
import com.example.productms.repository.CategoryRepository;
import com.example.productms.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultProductService implements ProductService {
  
  protected final ProductRepository productRepository;
  protected final CategoryRepository categoryRepository;
  
  @Autowired
  public DefaultProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }
  
  @Override
  public ProductResponse create(ProductRequest productRequest) {
    Product entity = new Product();
    BeanUtils.copyProperties(productRequest, entity);
  
    List<CategoryRequest> categoryRequests = productRequest.getCategories();
    List<Long> ids = categoryRequests.stream().map(c -> c.getId()).collect(Collectors.toList());
  
    List<Category> categories = categoryRepository.findAllById(ids);
    entity.setCategories(categories);
  
    Product saved = productRepository.save(entity);
    ProductResponse productResponse = new ProductResponse();
  
    BeanUtils.copyProperties(saved, productResponse);
    List<CategoryResponse> categoryResponses = saved.getCategories().stream().map(c -> {
      CategoryResponse categoryResponse = new CategoryResponse();
      BeanUtils.copyProperties(c, categoryResponse);
    
      return categoryResponse;
    }).collect(Collectors.toList());
    
    productResponse.setCategories(categoryResponses);
  
    return productResponse;
  }
  
  @Override
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }
  
  @Override
  public Page<ProductResponse> findAll(CustomPageRequest pageRequest) {
    return productRepository.findAll(pageRequest).map(p -> {
      ProductResponse productResponse = new ProductResponse();
      BeanUtils.copyProperties(p, productResponse);
  
      List<CategoryResponse> categoryResponses = p.getCategories().stream().map(c -> {
        CategoryResponse categoryResponse = new CategoryResponse();
        BeanUtils.copyProperties(c, categoryResponse);
    
        return categoryResponse;
      }).collect(Collectors.toList());
      
      productResponse.setCategories(categoryResponses);
  
      return productResponse;
    });
  }
  
  @Override
  public Product validateAndReturn(Long id, Integer quantity) {
    Product product = productRepository.findById(id).orElseThrow();
    if(product.getQuantity() < quantity) {
      throw new ResourceNotEnoughException(String.format("Product is not enough, currently: %s; requested: %s", product.getQuantity(), quantity));
    }
    
    return product;
  }
}
