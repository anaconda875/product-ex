package com.example.productms.data.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class CustomPageRequest extends PageRequest {
  
  protected final String keyword;

  public CustomPageRequest(int page, int size, Sort sort, String keyword) {
    super(page, size, sort);
    this.keyword = keyword;
  }
}
