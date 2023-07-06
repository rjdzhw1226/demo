package com.stream;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import com.util.OutUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * N*N皇后
 */
public class stream09 {
  private static final int n = 10;

  private static int[] col = new int[n*n];
  private static int count = 0;

  public static void main(String[] args) {
    System.out.println("当前为"+n+"皇后");
    TryPlay(n);
    System.out.println();
    System.out.println("结果为count:"+count);

  }

  public static int[][] EightInit(int[][] CharArray){
    for (int i = 0; i < CharArray.length; i++) {
      Arrays.fill(CharArray[i],0);
    }
    return CharArray;
  }

  //列的初值是0列 行的初值是0行
  public static void TryPlay(int row){
    int k = 1;
    col[k] = 1;
    while(k > 0){
      if(k <= row && col[k] <= row){
        if(check(k) == 0){
          col[k]++;
        }else{
          k++;
          col[k] = 1;
        }
      }else{
        if(k > row){
          count++;
          int[][] ints = showEight(row);
          //n*n防越界
          char[][] charResult = new char[n*n][n*n];
          for (int i = 1; i <= n; i++) {
            Arrays.fill(charResult[i],'K');
          }
          for (int i = 1; i <= n; i++) {
            System.out.println();
            for (int j = 1; j <= n; j++) {
              if(ints [i][j] == 1){
                charResult[i][j] = 'Q';
              }
              if(charResult[i][j] == 'Q'){
                OutUtil.print(charResult[i][j]+"  ");
              }else {
                System.out.print(charResult[i][j]+"  ");
              }
            }
          }System.out.println();
        }
        k--;
        col[k]++;
      }
    }
  }

  private static int[][] showEight(int s) {
    int[][] chars = new int[n*n][n*n];
    int[][] init = EightInit(chars);
    for (int i = 1; i <= s ; i++) {
      init[i][col[i]] = 1;
    }
    return init;
  }

  public static int check(int row){
    for (int i = 1; i < row; i++) {
      if((col[i]==col[row]) || (col[i]-col[row]==row-i) || (col[i]-col[row]==i-row)){
        return 0;
      }
    }
  return 1;
  }
}
