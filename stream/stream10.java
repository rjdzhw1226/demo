package stream;

import java.util.*;
import java.util.stream.Collectors;

public class stream10 {
  private static final int n = 4;
  private static int count01 = 0;
  //长度随n值改变
  private static final Integer[] addArray = {0,1,2,3};

  public static void main(String[] args) {

    char[][] chars = new char[n][n];
    int[][] ints = new int[n][n];

    while (true){
      for (int i = 0; i < n; i++) {
        Arrays.fill(ints[i],0);
      }
      int count = 0;
      int[][] play = Play(ints, n);

      if (check(Helpcheck(play, n), n)) {
        //最后做show抽取
        for (int i = 0; i < play.length; i++) {
          for (int j = 0; j < play.length; j++) {
            if (count%n == 0) {
              System.out.println();
            }
            if(play[i][j]==1){
              chars[i][j]='Q';
              //OutUtil.print(chars[i][j]+"  ");
            }else {
              chars[i][j]='K';
              System.out.print(chars[i][j]+"  ");
            }

            count++;
          }
        }
        System.out.println();
        if(SaveCheck(play) == 2){
          System.out.println(count01);
          break;
        };

      }
    }
  }

  public static int SaveCheck(int[][] checkArray){

    List<Integer> list = Arrays.stream(checkArray).map(s->{
      return Arrays.stream(s).boxed().collect(Collectors.toList());
    }).collect(Collectors.toList()).stream().flatMap(s -> s.stream()).collect(Collectors.toList());

    List<List<Integer>> list01 = new ArrayList<>();
    if(!list01.contains(list)){
      list01.add(list);
      count01++;
    }
    return count01;
  }

  public static int[][] Play(int[][] checkArray,int row){
    List<Integer> temp = Arrays.stream(addArray).collect(Collectors.toList());
    for (int i = 0; i < row; i++) {
      int col = (int) (Math.random() * n);
      if (temp.contains(col)){
        checkArray[i][col] = 1;
        int i1 = temp.indexOf(col);
        temp.remove(i1);
      }else{
        int colF = temp.get((int) (Math.random() * temp.size()));
        checkArray[i][colF] = 1;
        int i1 = temp.indexOf(colF);
        temp.remove(i1);
      }
    }
    return checkArray;
  }

  public static Map<Integer,Map<String,Integer>> Helpcheck(int[][] checkArray,int row){
    Map<Integer,Map<String,Integer>> map = new HashMap<>();
    int count = 1;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < row; j++) {
        if (checkArray[i][j] == 1) {
          Map<String,Integer> IndexMap = new HashMap<>();
          IndexMap.put("i",i);
          IndexMap.put("j",j);
          map.put(count,IndexMap);
          count++;
        }
      }
    }

    return map;
  }

  public static Boolean check(Map<Integer,Map<String,Integer>> map, int row){
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= row -i; j++) {
        Integer i1 = map.get(i).get("i");
        Integer j1 = map.get(i).get("j");
        Integer i2 = map.get(i + j).get("i");
        Integer j2 = map.get(i + j).get("j");

        if(Math.abs(i1-i2) == Math.abs(j1-j2)){
          return false;
        }
      }
    }
    return true;
  }
}
