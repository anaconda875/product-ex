package com.example.productms.config;

import com.example.productms.dto.request.OrderItem;
import com.example.productms.dto.request.OrderRequest;
import com.example.productms.dto.response.OrderResponse;
import com.example.productms.entity.Product;
import com.example.productms.exception.ResourceNotEnoughException;
import com.example.productms.service.ProductService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

@Configuration
public class ConsumerBindingConfig {
  
  @Bean
  public Consumer<OrderRequest> orderListener(ProductService productService, StreamBridge streamBridge) {
    return msg -> {
      System.out.println(msg.getClass());
      System.out.println(msg);
      List<OrderItem> items = msg.getItems();
      
      List<Product> products = new ArrayList<>();
      List<OrderItem> errorItems = new ArrayList<>();
      
      for (OrderItem item : items) {
        try {
          Product product = productService.validateAndReturn(item.getId(), item.getQuantity());
          products.add(product);
        } catch (ResourceNotEnoughException | NoSuchElementException e) {
          e.printStackTrace();
          errorItems.add(item);
        }
      }
      
      if(!errorItems.isEmpty()) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setUuid(msg.getUuid());
        orderResponse.setErrorCode("999");
        orderResponse.setMessage("Co loi xay ra");
        orderResponse.setErrorItems(errorItems);
        
        streamBridge.send("orderErrorResponse-out-0", orderResponse);
      }
      
    };
  }
  
}
