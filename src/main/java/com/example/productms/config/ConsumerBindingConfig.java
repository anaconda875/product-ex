package com.example.productms.config;

import com.example.productms.dto.request.OrderRequest;
import com.example.productms.service.ProductService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class ConsumerBindingConfig {
  
  @Bean
  public Consumer<OrderRequest> orderListener(ProductService productService, StreamBridge streamBridge) {
    return msg -> {
      productService.doCreateOrder(streamBridge, msg);
    };
  }
  
}
