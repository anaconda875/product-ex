package com.example.productms.service;

import com.example.productms.dto.request.CategoryRequest;
import com.example.productms.dto.response.CategoryResponse;
import com.example.productms.entity.Category;
import com.example.productms.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCategoryService implements CategoryService {
  
  @Override
  public CategoryResponse create(CategoryRequest categoryRequest) {
    CategoryResponse categoryResponse = new CategoryResponse();
    categoryResponse.setName("dummy");
    return categoryResponse;
  }
  
  @Override
  public List<CategoryResponse> findAll() {
    return null;
  }
  
}
