package io.bayrktlihn.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article extends BaseEntity {
  private Category category;

  private String name;

  private String imageUrl;

  private BigDecimal price;

  private String description;

  private LocalDate validFrom = LocalDate.now();

  private LocalDate validTo = LocalDate.MAX;

  public Article(Category category, String name, String imageUrl, BigDecimal price, String description) {
    this.category = category;
    this.name = name;
    this.imageUrl = imageUrl;
    this.price = price;
    this.description = description;
  }



}
