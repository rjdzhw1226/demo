package com.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.random;

/**
 * 八皇后问题，JAVA流处理
 * 整体思路为先构建棋盘，再随机放入皇后于随机位置，校验成功则输出，col为列数做递归，MAX为棋盘皇后个数，BOARDSIZE为棋盘大小
 */
public class stream05 {
  public static final int MAX = 4;
  public static final int COL = 2;
  public static final int BOARDSIZE = 16;
  public static final int LEFT = MAX-1;
  public static final int RIGHT = MAX+1;
  public static int count = 0;

  public static void main(String[] args) {

    //死循环校验，如果为false跳出
    while(true){
      List<List<Integer>> lists = EightQueen(COL, BOARDSIZE);
      //校验随机位数再做校验
      if (count == MAX) {
        count = 0;
        List<Integer> sign = new ArrayList<>();
        int[] arraySign = new int[MAX];
        for (int i = 0; i < lists.size(); i++) {
          //取索引
          if(lists.get(i).get(0) == 0){
            sign.add(i);
          }
        }
        System.out.println(sign);
        //转数组
        for (int i = 0; i < sign.size(); i++) {
          arraySign[i]=sign.get(i);
        }
        //做位置验证
        if (HelpEightQueen(arraySign,MAX,BOARDSIZE)) {
          System.out.print(lists);
          break;
        }
      }else{
        count = 0;
      }
    }
    //System.out.println(EightQueen(MAX, 8));
  }

  /**
   * 校验方法抽取
   * @param sign
   * @param MAX
   * @param BOARDSIZE
   * @return
   */
  public static Boolean HelpEightQueen(int[] sign ,int MAX, int BOARDSIZE){
    if(sign.length==MAX){
      for (int j = 0; j < sign.length; j++) {
        for (int k = 1; k < sign.length-j; k++) {
          //判断行
          if (Math.abs(sign[j]-sign[j+k])<MAX) {
            if (sign[j]<=MAX){
              if(!(sign[j]<=(MAX-1) && sign[j+k]>(MAX-1))){
                return false;
              }
            }else if(sign[j]>MAX && sign[j]<=MAX*2){
              if(!(sign[j]<=(MAX*2-1) && sign[j+k]>(MAX*2-1))){
                return false;
              }
            }else if(sign[j]>MAX*2 && sign[j]<=MAX*3){
              if(!(sign[j]<=(MAX*3-1) && sign[j+k]>(MAX*3-1))){
                return false;
              }
            }else if(sign[j]>MAX*3 && sign[j]<=MAX*4){
              if(Math.abs(sign[j]-sign[j+k])<MAX){
                return false;
              }
            }
          }
          for (int l = 1; l <= MAX; l++) {
            // 判断列
            if(Math.abs(sign[j]-sign[j+k])==(MAX*l)){
              return false;
            }
            // 判断左对角线
            if (sign[j]==MAX-1||sign[j]==BOARDSIZE-1) {
              if (Math.abs(sign[j]-sign[j+k])==((MAX-1)*(l-1))) {
                return false;
              }
            }else{
              if (Math.abs(sign[j]-sign[j+k])==((MAX-1)*(l-2))) {
                return false;
              }
            }
            // 判断右对角线
            if(sign[j]==0||sign[j]==1+(BOARDSIZE/MAX)*MAX-1) {
              if (Math.abs(sign[j] - sign[j + k]) == ((MAX + 1) * (l - 1))) {
                return false;
              }
            } else{
              if (Math.abs(sign[j]-sign[j+k])==((MAX+1)*(l-2))) {
                return false;
              }
            }
          }
        }
      }
    }else{
      return false;
    }
    return true;
  }
  public static List<List<Integer>> EightQueen(int col,int boardSize){
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
    //第一步，随机生成MAX个，1~boardSize的随机数
    List<Integer> list03 = new ArrayList<>();
    List<Integer> list04 = new ArrayList<>();
    for (int i = 0; i < MAX; i++) {
      list03.add((int) (1 + random() * boardSize));
    }
    //随机校验并传入
    if(!list03.contains(restQueens.get(0))){
      tryPlaySolutions.add(restQueens);
    }else {
      list04.add(0);
      tryPlaySolutions.add(list04);
    }
    //计数，用作过滤校验
    if (tryPlaySolutions.get(0).get(0)==0) {
      count++;
    }
    return tryPlaySolutions;
  }

  /**
   * 校验做流处理，再做考虑，目前未在此做校验，使用数组做校验
   * @param t
   * @return
   */
  private static Boolean checkTryPlay(List<Integer> t){
    if(t.size()!=0){
      if(t.get(0)==0){
        return true;
      }else{
        return true;
      }
    }else{
      return true;
    }

  }
}
