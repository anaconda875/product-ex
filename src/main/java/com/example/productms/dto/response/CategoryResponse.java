package com.example.productms.dto.response;

import com.example.productms.entity.Product;
import lombok.Data;

import java.util.List;

//DTO: Data transfer object
@Data
public class CategoryResponse {
  
  private Long id;
  private String name;
  private List<ProductResponse> products;
}
