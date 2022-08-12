package io.bayrktlihn.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseEntity {
  private String name;

  private String imageUrl;
}
