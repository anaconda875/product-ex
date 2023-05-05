package com.example.productms.dto.request;

import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class OrderRequest {

  private String uuid;
  private String customerName;
  private String address;
  
  @Size(min = 1, max = 100)
  private List<OrderItem> items;

}
