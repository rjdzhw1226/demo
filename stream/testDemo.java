package com.stream;

public class testDemo {
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

  public testDemo(Integer id, Integer num) {
    this.id = id;
    this.num = num;
  }

  public testDemo() {
  }

  @Override
  public String toString() {
    return "testDemo{" +
      "id=" + id +
      ", num=" + num +
      '}';
  }
}
