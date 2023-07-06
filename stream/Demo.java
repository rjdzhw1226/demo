package com.stream;

import org.hibernate.mapping.Array;

import java.util.List;

public class Demo {
  private Integer id;
  private Integer num;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public Demo(Integer id, Integer num) {
    this.id = id;
    this.num = num;
  }

  public Demo(Integer id) {
    this.id = id;
  }
  public Demo() {
  }

  @Override
  public String toString() {
    return "Demo{" +
      "id=" + id +
      ", num=" + num +
      '}';
  }
}
