package com.example.productms.dto.response;

import com.example.productms.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
  
  private Long id;
  private String name;
  private Double price;
  private Integer quantity;
  private Product.Type type;
  private List<CategoryResponse> categories;
  
}
