package stream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class test {

  public static void main(String[] args) {
    /*for (int i = 1; i <= 16; i++) {

      System.out.print(" "+i+" ");
      if (i<=9){
        System.out.print(" ");
      }
      if (i%4==0){
        System.out.println();
      }
    }*/

    //缺什么new什么

    //底层 类似于c的数组 直接声明变量类型即可使用
    int[] i = {59, 13, 8, 1, 29, 56, 36, 6};

    int[] ints = new int[]{59, 13, 8, 1, 29, 56, 36, 6};//数组，写法多种

    System.out.print("Array:");
    for (int i1 = 0; i1 < ints.length; i1++) {
      System.out.print(ints[i1]);
      if (i1==ints.length-1){
        System.out.println(";");
      }else{
        System.out.print(",");
      }

    }
    List<Integer> arraylist = new ArrayList<>();//多态写法，直接new接口的实现类
    arraylist.add(0,59);
    arraylist.add(1,13);
    arraylist.add(2,8);
    arraylist.add(3,1);
    arraylist.add(4,29);
    arraylist.add(5,56);
    arraylist.add(6,36);
    arraylist.add(7,6);


    Demo demo = new Demo(1,59);
    List<Demo> demolist = new ArrayList<>();


    demolist.add(demo);
    demolist.add(new Demo(2,6));
    demolist.add(new Demo(3,4));
    for (int i1 = 0; i1 < demolist.size(); i1++) {
      HashMap<Integer, Integer> objectObjectHashMap = new HashMap<>();
      objectObjectHashMap.put(demolist.get(i1).getId(),demolist.get(i1).getNum());
    }
    Map<Integer, Integer> collect = demolist.stream().collect(Collectors.toMap(Demo::getId, Demo -> Demo.getNum()));
    collect.forEach((k,v)-> System.out.println(k+"\t"+v));


    //List<Integer>
    List<List<Integer>> newList = new ArrayList<>();
      for (int j = 0; j < 8 ; j++) {
        List<Integer> init = new ArrayList<>();
        init.add(ints[j]);
        newList.add(init);
      }
    System.out.println("newList:"+newList);



    System.out.println("List:"+arraylist+";");
    System.out.println("过滤后的List:"+arraylist.stream().filter(s -> s > 9).collect(Collectors.toList())+";");
    //System.out.println("过滤后的List:"+arraylist.stream().filter(s -> s > 9).collect(Collectors.toMap())+";");
    List<Integer> linkedList = new LinkedList<>();
    List<Integer> vector = new Vector<>();

    Map<Integer, Integer> map = new HashMap<>();//同上，多态写法
    map.put(0,59);
    map.put(1,13);
    map.put(2,8);
    map.put(3,1);
    map.put(4,29);
    map.put(5,56);
    map.put(6,36);
    map.put(7,6);
    System.out.print("Map:"+map+";");
    HashSet<String> set = new HashSet<>();

    Collection<Object> listCollect = new ArrayList<>();//Collection 为超级接口 list set 的父接口 类似于抽象类 可以被实现 具体参考下图

    //System.out.println(HelpEightQueen(i,8,64));

  }
  public static Boolean HelpEightQueen(int[] sign ,int MAX, int BOARDSIZE){
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
          //判断列
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
          if(sign[j]==0||sign[j]==1+(BOARDSIZE/MAX)*MAX-1){
            if (Math.abs(sign[j]-sign[j+k])==((MAX+1)*(l-1))) {
              return false;
            }
          }else{
            if (Math.abs(sign[j]-sign[j+k])==((MAX+1)*(l-2))) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

}
