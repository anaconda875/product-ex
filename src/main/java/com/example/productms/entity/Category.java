package com.example.productms.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_category")
@Data
public class Category {
  
  @Id
  @GeneratedValue
  private Long id;
  
  @Basic(optional = false)
  private String name;
  
  @ManyToMany(mappedBy = "categories")
  private List<Product> products;
  
}
