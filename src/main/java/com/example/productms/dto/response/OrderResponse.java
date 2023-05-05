package com.example.productms.dto.response;

import com.example.productms.dto.request.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
  
  private String uuid;
  private String errorCode;
  private List<OrderItem> errorItems;
  private String message;
  
}
