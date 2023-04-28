package com.example.productms.service;

import com.example.productms.dto.request.CategoryRequest;
import com.example.productms.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
  
  CategoryResponse create(CategoryRequest category);
  
  List<CategoryResponse> findAll();
}
