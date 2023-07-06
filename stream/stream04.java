package com.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class stream04 {
  public static void main(String[] args) {
    userInfo users = new userInfo();
    List<userInfo> userInfoList = new ArrayList<>();
    userInfoList.add(new userInfo(1L,"程序员",18));
    userInfoList.add(new userInfo(1L,"项目经理",30));
    userInfoList.add(new userInfo(2L,"小学生",12));


    List<userInfo> collect = userInfoList.stream().collect(Collectors.toList());
    collect.forEach(System.out::println);

    Map<Long, userInfo> map = userInfoList.stream().collect(Collectors.toMap(userInfo::getId, userInfo -> userInfo, (k1, k2) -> k2));
    //map.values().forEach(a-> System.out.println(a.getName()));


    Map<String , Object> map01 = new HashMap<>();
    List<Map<String , Object>> maps = new ArrayList<>();
    map.forEach((k,v)-> System.out.println(k+":\t"+v));

  }
}
