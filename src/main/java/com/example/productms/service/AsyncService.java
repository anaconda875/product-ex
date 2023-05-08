package com.example.productms.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
  
  @Async
  public void asyncMethodWithVoidReturnType() {
    System.out.println("Execute method asynchronously. "
        + Thread.currentThread().getName());
  }

}
