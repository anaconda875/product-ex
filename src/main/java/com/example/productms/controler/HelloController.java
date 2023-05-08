package com.example.productms.controler;

import com.example.productms.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping("/apis/v1")
public class HelloController {
  
  protected final AsyncService asyncService;
  
  protected int port;
  
  public HelloController(AsyncService asyncService) {
    this.asyncService = asyncService;
  }
  
  @GetMapping("/hello/{name}")
  public String hello(@PathVariable String name, Integer age) {
    if(age < 18) {
      throw new IllegalArgumentException("ko du tuoi");
    }
    return "Hello " + name + ", port: " + port;
  }
  
  @PostMapping("/hello2")
  public String hello2() {
    return "Hello2";
  }
  
  @Autowired
  public void setPort(@Value("${server.port}") int port) {
    this.port = port;
  }
}
