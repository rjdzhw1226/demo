package com.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class stream02 {
  public static void main(String[] args) {
    ArrayList<Integer> array = new ArrayList<>();
    Collections.addAll(array ,1,2,3,4,5,6,7,8,9,10);
    //System.out.println(array);
    List<Integer> collect = array.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    System.out.println(collect);
  }
}
