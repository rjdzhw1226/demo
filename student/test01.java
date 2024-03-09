//package student;
//
//import com.alibaba.fastjson.JSON;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * 测试用
// */
//public class test01 {
//  public static void main(String[] args) throws Exception {
////    FileInputStream file = new FileInputStream("D:/day01/lianxi02/src/main/java/student/Data.txt");
////    InputStreamReader read = new InputStreamReader(file);
////    BufferedReader bufferedReader = new BufferedReader(read);
////    String s = "";
////    while((s = bufferedReader.readLine())!=null){
////
////      write.get(s);
////      System.out.println();
////    }
////    bufferedReader.close();
//    //test(new teacher());
//    String s = "{\"classname\":\"teacher\",\"name\":\"mayanlong\",\"salary\":\"1200\",\"age\":\"23\",\"subject\":\"shuxue\"}";
//    String substring = s.substring(1, s.length() - 1);
//    for (String s1 : substring.split(",")) {
//      for (String s2 : s1.split(":")) {
//        String substring1 = s2.substring(1, s2.length() - 1);
//        System.out.println(substring1);
//      }
//    }
//  }
//
//  public static void test(Object obj) throws Exception{
//    Class classname = obj.getClass();
//    String simpleName = classname.getSimpleName();
//
//    List<Object> objList = new ArrayList<>();
//    List<Object> objListBefore = new ArrayList<>();
//    FileInputStream file = new FileInputStream("D:/day01/lianxi02/src/main/java/student/Test.txt");
//    InputStreamReader read = new InputStreamReader(file);
//    BufferedReader bufferedReader = new BufferedReader(read);
//    System.out.println(obj.getClass().getSimpleName());
//    String s = "";
//    while((s = bufferedReader.readLine())!=null){
//      Object object = JSON.parseObject(s, Object.class);
//
//      objListBefore.add(object);
//      objList = objListBefore.stream().distinct().collect(Collectors.toList());
//
//    }
//    System.out.println(objList);
//    bufferedReader.close();
//  }
//}
