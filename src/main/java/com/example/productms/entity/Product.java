package com.example.productms.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_product")
@Data
public class Product {
  
  @Id
  @GeneratedValue
  private Long id;
  
  @Basic(optional = false)
  private String name;
  
  @Basic(optional = false)
  private Double price;
  
  @Basic(optional = false)
  private Integer quantity;
  
  @Enumerated(EnumType.ORDINAL)
  private Type type;
  
  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private List<Category> categories;
  
  public enum Type {
    PHYSICAL,
    DIGITAL
  }
}
