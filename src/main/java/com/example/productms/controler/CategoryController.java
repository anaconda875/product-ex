package com.example.productms.controler;

import com.example.productms.dto.request.CategoryRequest;
import com.example.productms.dto.response.CategoryResponse;
import com.example.productms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1/categories")
public class CategoryController {
  
  protected final CategoryService categoryService;
  
  @Autowired
  public CategoryController(@Qualifier("defaultCategoryService") CategoryService categoryService) {
    this.categoryService = categoryService;
  }
  
  @PostMapping
  public CategoryResponse create(@RequestBody CategoryRequest categoryRequest) {
    return categoryService.create(categoryRequest);
  }
  
  @GetMapping
  public List<CategoryResponse> findAll() {
    return categoryService.findAll();
  }
  
}
