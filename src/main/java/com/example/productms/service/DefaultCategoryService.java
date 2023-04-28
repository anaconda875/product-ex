package com.example.productms.service;

import com.example.productms.dto.request.CategoryRequest;
import com.example.productms.dto.response.CategoryResponse;
import com.example.productms.entity.Category;
import com.example.productms.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCategoryService implements CategoryService {
  
  protected final CategoryRepository categoryRepository;
  
  @Autowired
  public DefaultCategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }
  
  @Override
  public CategoryResponse create(CategoryRequest categoryRequest) {
    Category entity = new Category();
    BeanUtils.copyProperties(categoryRequest, entity);
    
    Category saved = categoryRepository.save(entity);
    CategoryResponse categoryResponse = new CategoryResponse();
    BeanUtils.copyProperties(saved, categoryResponse);
    
    return categoryResponse;
  }
  
  @Override
  public List<CategoryResponse> findAll() {
    return categoryRepository.findAll().stream().map(c -> {
      CategoryResponse categoryResponse = new CategoryResponse();
      BeanUtils.copyProperties(c, categoryResponse);
      return categoryResponse;
    }).collect(Collectors.toList());
  }
  
}
