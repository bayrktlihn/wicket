package io.bayrktlihn.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order extends BaseEntity {
  private Table table;

  private Article article;

  private Integer quantity;

  private OrderStatus status;

  private BigDecimal totalPrice;
}
