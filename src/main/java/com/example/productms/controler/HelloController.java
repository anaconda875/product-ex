package com.example.productms.controler;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/v1")
public class HelloController {
  
  //PATH VARIABLE
  @GetMapping("/hello/{name}")
//  @PostMapping
//  @PutMapping
//  @DeleteMapping
  public String hello(@PathVariable String name, Integer age) {
    return "Hello " + name + ", age: " + age;
  }
  
  @PostMapping("/hello2")
  public String hello2() {
    return "Hello2";
  }
}
