package com.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class stream03 {

  public static void main(String[] args) {
    ArrayList<String> array = new ArrayList<>();

    array.add("张伟,36");
    array.add("曾小贤,33");
    array.add("关谷神奇,30");
    array.add("吕子乔,32");
    array.add("陆展博,28");
    array.add("赵海棠,25");

    ArrayList<String> array01 = new ArrayList<>();
    array01.add("胡一菲,31");
    array01.add("陈美嘉,33");
    array01.add("林婉瑜,30");
    array01.add("唐悠悠,32");
    array01.add("秦羽墨,28");
    array01.add("诸葛大力,25");


    //List<String> list = array.stream().filter(s -> s.split(",")[0].length() == 3).limit(5).collect(Collectors.toList());
    //System.out.println(list);

    List<String> list1 = array01.stream().filter(s -> s.split(",")[0].substring(0, 1) != "杨").skip(1).collect(Collectors.toList());
    System.out.println(list1);
  }
}
