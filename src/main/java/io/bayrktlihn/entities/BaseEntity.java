package io.bayrktlihn.entities;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEntity implements Serializable {
  private Long id;
}
