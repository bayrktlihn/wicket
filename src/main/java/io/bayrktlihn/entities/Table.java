package io.bayrktlihn.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table extends BaseEntity {
  private String name;

  private Integer seatCount;

  private Boolean orderableElectronically = Boolean.TRUE;

  public Table(String name, Integer seatCount) {
    this.name = name;
    this.seatCount = seatCount;
  }



}
