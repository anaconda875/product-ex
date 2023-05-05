package com.example.productms.exception;

public class ResourceNotEnoughException extends RuntimeException {
  
  public ResourceNotEnoughException() {
  }
  
  public ResourceNotEnoughException(String message) {
    super(message);
  }
}
