package com.example.productms.dto.request;

import com.example.productms.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductRequest {
  
  private Long id;
  private String name;
  private Double price;
  private Integer quantity;
  private Product.Type type;
  private List<CategoryRequest> categories;

}
