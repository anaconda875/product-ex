package com.example.productms.dto.request;

import com.example.productms.entity.Product;
import lombok.Data;

//import java.util.List;

//DTO: Data transfer object
@Data
public class CategoryRequest {
  
  private Long id;
  private String name;
//  private List<Product> products;
}
