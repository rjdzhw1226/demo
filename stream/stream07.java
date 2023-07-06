package com.stream;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.random;

/**
 * N*N皇后
 */
public class stream07 {
  //随机数数组
  public static List<Integer> checkList = new ArrayList<>();
  //列数
  public static final int MAX = 8;
  //初始化矩阵
  public static int[][] array = new int[MAX][MAX];
  //棋盘大小
  public static int COUNT = 64;
  //计数，用来校验次数和输出所有情况，暂时还没想好
  public static int count = 1;

  //主函数
  public static void main(String[] args) {
    System.out.println("请等待！");
    //初始化矩阵
    int l = 1;
    for (int i = 0; i < MAX; i++) {
      for (int j = 0; j < MAX; j++) {
        array[i][j] = l;
        l++;
      }
    }
    //死循环输出
    while (true) {
      //new一个List
      List<Integer> tryList = new ArrayList<>();
      //随机数生成
      for (int i = 0; i < MAX; i++) {
        tryList.add((int) (1 + i*MAX + random() * MAX));
      }
      //校验重复
      if (tryList.stream().distinct().collect(Collectors.toList()).size() == MAX) {
        checkList = tryList;
        //调用
        if (check(HelpEightQueen(checkList))) {
          System.out.println("成功：" + checkList);
          //矩阵输出
          List<Integer> collect = EightQueen(MAX, COUNT).stream().flatMap(s -> s.stream()).collect(Collectors.toList());
          int g = 0;
          for (int i = 0; i < collect.size(); i++) {
            g++;
            System.out.print(collect.get(i)+", ");
            if (collect.get(i)<=9 && collect.get(i)!=0){
              System.out.print(" ");
            }
            if (g == MAX) {
              System.out.println();
              g=0;
            }
          }
        }
      }
    }
//    测试用部分
//    List<Integer> ints = Arrays.asList(new Integer[]{48, 13, 63, 4, 38, 51, 26, 17});
//    HelpEightQueen(ints).forEach(System.out::println);
//    System.out.println(check(HelpEightQueen(ints)));
  }

  /**
   * 检查方法
   * @param list
   * @return
   */
  public static Boolean check( List<Map<Integer, List<Map<String,Integer>>>> list){

    //取索引并校验
    for (Integer j = 0; j < list.size(); j++) {
      for (Integer k = 0; k < list.size()-1-j; k++) {
        Integer i1 = list.get(j).get(j).get(0).get("i");

        Integer i2 = list.get((k+1+j)).get((k+1+j)).get(0).get("i");

        Integer j1 = list.get(j).get(j).get(1).get("j");

        Integer j2 = list.get((k+1+j)).get(k+1+j).get(1).get("j");
        //行，列，对角线校验
        if(!(i1!=i2 && j1!=j2 && Math.abs(i1-i2)!=Math.abs(j1-j2))){
          return false;
        }
      }
    }
    return true;
  }

  /**
   * 生成校验格式方法
   * @param list
   * @return
   */
  public static List<Map<Integer, List<Map<String,Integer>>>> HelpEightQueen(List<Integer> list){
    //随机数取索引并存储
    List<Map<Integer, List<Map<String,Integer>>>> map = new ArrayList<>();
    Integer o = 0;
    for (Integer i = 0; i < MAX; i++) {
      for (Integer j = 0; j < MAX; j++) {
        for (Integer k = 0; k < list.size(); k++) {
          if(list.get(k) == array[i][j]){
            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Integer> map2 = new HashMap<>();
            List<Map<String,Integer>> map3 = new ArrayList<>();
            Map<Integer,List<Map<String,Integer>>> map4 = new HashMap<>();
            map1.put("i",i);map2.put("j",j);
            map3.add(map1);map3.add(map2);
            map4.put(o,map3);
            map.add(map4);
            o++;
          }
        }
      }
    }
    return map;
  }

  /**
   * 目前为递归生成，后续再做考虑
   * @param col
   * @param boardSize
   * @return
   */
  public static List<List<Integer>> EightQueen(int col, int boardSize){
    List<List<Integer>> solutions = new ArrayList<>();
    if (col == 1) {
      for (int i = 1; i <= boardSize ; i++) {
        List<Integer> init = new ArrayList<>();
        init.add(i);
        solutions.add(init);
      }
      return solutions;
    }
    List<List<Integer>> restQueenSolutions = EightQueen(col-1,boardSize);
    return restQueenSolutions.stream()
      .map(restQueens -> tryPlay(restQueens,boardSize))
      .flatMap(tryPlaySolutions -> tryPlaySolutions.stream())
      .filter(t -> checkTryPlay(t))
      .collect(Collectors.toList());
  }

  private static List<List<Integer>> tryPlay(List<Integer> restQueens, int boardSize){
    List<List<Integer>> tryPlaySolutions = new ArrayList<>();
    List<Integer> list04 = new ArrayList<>();
    List<Integer> list05 = new ArrayList<>();
    //第一步，随机生成MAX个，1~boardSize的随机数

    //随机校验并传入
    if(!checkList.contains(restQueens.get(0))){
      tryPlaySolutions.add(restQueens);
    }else {
      list04.add(0);
      tryPlaySolutions.add(list04);
    }
    return tryPlaySolutions;
  }

  private static Boolean checkTryPlay(List<Integer> t) {
    return true;
  }
}
