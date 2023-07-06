package com.stream;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class stream01 {

  public static void main(String[] args) {

    ArrayList<String> array = new ArrayList<>();
    array.add("zhangSan,24");
    array.add("liSi,26");
    array.add("wangWu,25");
    array.add("zhaoLiu,22");
    array.add("qianQi,23");

    Map<String, Integer> map = array.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
      .collect(Collectors.toMap(new Function<String, String>() {
        @Override
        public String apply(String s) {
          return s.split(",")[0];
        }
      }, new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
          return Integer.parseInt(s.split(",")[1]);
        }
      }));


    Map<String, Integer> map01 = array.stream()
      .filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
      .collect(Collectors.toMap(s -> s.split(",")[0],
                                s -> Integer.parseInt(s.split(",")[1])));

    System.out.println(map);

  }
}
