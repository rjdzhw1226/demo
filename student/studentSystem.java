package student;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static student.write.readFile;

/**
 * 学生管理系统(任意类)
 */
public class studentSystem {
  static int count = 0;
  private static String choose = "";
  public static void main(String[] args) throws Exception {
    student st = new student();
    teacher te = new teacher();
    Scanner sc = new Scanner(System.in);
    System.out.println("管理系统登陆");
    System.out.println("请输入用户：");
    String next0 = sc.next();
    System.out.println("请输入密码：");
    String next1 = sc.next();
    if(login(next0,next1)){
      systemBean(te);
    }else{
      System.out.println("------------------------ No pass and system closed --------------------------");
    }
  }

  public static Boolean login(String username, String password){
    return readFile(username,password);
  }
  public static void systemBean(Object obj) throws Exception{
    Class classname = obj.getClass();
    String simpleName = classname.getSimpleName();
    System.out.println(simpleName);

    List<Object> objList = new ArrayList<>();
    List<Object> objListBefore = new ArrayList<>();

    List<student> studentList = new ArrayList<>();
    //List<student> studentListBefore = new ArrayList<>();

    File file01 = new File("D:/day01/lianxi02/src/main/java/student/"+simpleName+"Test.txt");
    if (!file01.exists()){
        file01.createNewFile();
    }else{
      System.out.println("File already exists(create file already done)");
    }
    FileInputStream file = new FileInputStream(file01);
    InputStreamReader read = new InputStreamReader(file);
    BufferedReader bufferedReader = new BufferedReader(read);

    String s = "";
    while((s = bufferedReader.readLine())!=null){
      //student st = JSON.parseObject(s, student.class);
      Object obj01 = JSON.parseObject(s,Object.class);
      objListBefore.add(obj01);
      objList = objListBefore.stream().distinct().collect(Collectors.toList());
    }
    bufferedReader.close();

    while(true){
      System.out.println("--------------------welcome to "+simpleName+" manage system backstage interface--------------------");
      System.out.println("1:add "+simpleName);
      System.out.println("2:search "+simpleName);
      System.out.println("3:change "+simpleName);
      System.out.println("4:delete "+simpleName);
      System.out.println("5:exit system");
      System.out.println("--------------------------------------------------------------");
      System.out.println("please input your choose：");
      Scanner sc = new Scanner(System.in);
      choose = sc.next();
//      switch (choose){
//        case "1" :
//          System.out.println("The information of add "+simpleName+":"+addStudent(studentList,obj).toString());
//          break;
//        case "2" :
//          selectStudent(studentList,simpleName);
//          break;
//        case "3" :
//          if (updateStudent(studentList,simpleName)) {
//            System.out.println("change succeed");
//          }else{
//            System.out.println("change failed");
//          }
//          break;
//        case "4" :
//          if (deleteStudent(studentList,simpleName)) {
//            System.out.println("delete succeed");
//          }else{
//            System.out.println("delete failed");
//          }
//          break;
//        case "5" :
//          System.out.println("exit");
//          System.out.println("------------------------"+simpleName+" manage system closed --------------------------");
//          System.exit(0);
//        default:
//          System.out.println("Without this selection, please try input again!");
//      }
      switch (choose){
        case "1" :
          System.out.println("The information of add "+simpleName+":"+addStudent(objList,obj).toString());
          break;
        case "2" :
          selectStudent(objList,simpleName);
          break;
        case "3" :
          if (updateStudent(objList,obj)) {
            System.out.println("change succeed");
          }else{
            System.out.println("change failed");
          }
          break;
        case "4" :
          if (deleteStudent(objList,simpleName)) {
            System.out.println("delete succeed");
          }else{
            System.out.println("delete failed");
          }
          break;
        case "5" :
          System.out.println("exit");
          System.out.println("------------------------"+simpleName+" manage system closed --------------------------");
          System.exit(0);
        default:
          System.out.println("Without this selection, please try input again!");
      }
    }

  }

  private static Object addStudent(List<Object> objList,Object obj) throws Exception{
    List<String> ObjString = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    String simpleName = obj.getClass().getSimpleName();

    System.out.println("add "+obj.getClass().getSimpleName());

    Field[] fields = obj.getClass().getDeclaredFields();

    for (Field field : fields) {
      String name = field.getName();

      field.setAccessible(true);

      if (name.equals("classname")) {

        String value = simpleName;

        ObjString.add("\""+name+"\""+":"+"\""+value+"\"");
      }else {
        System.out.println("please input "+name+" :");

        String value = sc.next();

        ObjString.add("\""+name+"\""+":"+"\""+value+"\"");
      }
    }
    Object o = write.writeString(ObjString, simpleName, objList);


//    student st = new student();
//    System.out.println("请输入姓名");
//    st.setName(sc.next());
//    System.out.println("请输入年龄");
//    st.setAge(sc.nextInt());
//    System.out.println("请输入地址");
//    st.setAddress(sc.next());
//    System.out.println("请输入ID");
//    st.setId(sc.next());
//    System.out.println("输入完成");
//    write.method1(st);
//    studentList.add(st);
    return o;
  }

  private static Boolean deleteStudent(List<Object> objList,String classname){
//    if(studentList == null || studentList.size()==0){
//      return false;
//    }
//    Scanner sc = new Scanner(System.in);
//    System.out.println("There has "+studentList.size()+" "+classname+"s"+", please input the "+classname+".No of you want to delete");
//    int i = sc.nextInt() - 1;
//    if(i > studentList.size() || i < 0){
//      return false;
//    }
//    studentList.remove(i);
//    try {
//      write.delFile(i+1);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    return true;
    if(objList == null || objList.size()==0){
      return false;
    }
    Scanner sc = new Scanner(System.in);
    System.out.println("There has "+objList.size()+" "+classname+"s"+", please input the "+classname+".No of you want to delete");
    int i = sc.nextInt() - 1;
    if(i > objList.size() || i < 0){
      return false;
    }
    objList.remove(i);
    try {
      write.delFile(i+1,classname);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return true;
  }

  /**
   * 异常处理后循环未做
   * @param objList
   * @param obj
   * @return
   */

  private static Boolean updateStudent(List<Object> objList,Object obj){
    String classname = obj.getClass().getSimpleName();
    List<String> NewResult = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    System.out.println("There has "+objList.size()+" "+classname+"s"+", please input the "+classname+".No of you want to change");
    int i = sc.nextInt() - 1;
    if(i > objList.size() || i < 0 || objList.size() == 0){
      return false;
    }
    Object obj01 = write.dataCh(i + 1, obj);
    String[] split = null;
    String in = null;
    System.out.println("The information of "+classname+" before change: "+objList.get(i).toString());
    do{
      System.out.println("--------------------------------------------------------------------------");
      Field[] fields = obj.getClass().getDeclaredFields();
      for (int j = 0; j < fields.length ; j++) {
        NewResult.add(fields[j].getName());
        if(!fields[j].getName().equals("classname")){
          System.out.println((j)+": "+fields[j].getName());
        }
      }
      System.out.println("--------------------------------------------------------------------------");
      System.out.println("please input the setName(字段名) you want change: ");
      in = sc.next();


      if(!NewResult.contains(in)){
        count++;
        System.out.println("input error, please try again!");
      }else{
        count = 0;
      }
    }while (count != 0);
    List<String> result = new ArrayList<>();


    //修改
    String s = JSON.toJSONString(obj01);
    String substring = s.substring(1, s.length() - 1);

    for (String s1 : substring.split(",")) {
      split = s1.split(":");
      for (int j = 0; j < split.length; j++) {
        String substring1 = split[j].substring(1, split[j].length() - 1);
        result.add(substring1);
      }
    }

    System.out.println("please input the setName(字段名) value you want change: ");
    String value = sc.next();
    for (int j = 0; j < result.size() ; j++)
    {
      if (result.get(j).equals(in)) {
        result.remove(j+1);
        result.add(j+1,value);
      }
    }

      //拼接
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("{");

      for (int j = 0; j < result.size(); j++) {
        if (j%2==0&&j!=result.size()-1) {
          stringBuilder.append("\"").append(result.get(j)).append("\"").append(":");
        }else if(j==result.size()-1){
          stringBuilder.append("\"").append(result.get(j)).append("\"");
        }else{
          stringBuilder.append("\"").append(result.get(j)).append("\"").append(",");
        }
      }
      stringBuilder.append("}");
      //System.out.println(stringBuilder.toString());
    Object object = JSON.parseObject(stringBuilder.toString(), Object.class);

//      switch (in){
//        case 1 :
//          System.out.println("请输入姓名：");
//          st.setName(sc.next());
//          count = 0;
//          break;
//        case 2 :
//          System.out.println("请输入ID：");
//          st.setId(sc.next());
//          count = 0;
//          break;
//        case 3 :
//          System.out.println("请输入地址：");
//          st.setAddress(sc.next());
//          count = 0;
//          break;
//        case 4 :
//          System.out.println("请输入年龄：");
//          st.setAge(sc.nextInt());
//          count = 0;
//          break;
//        default:
//          System.out.println("没有这个选项，请重试！");
//          count++;
//      }

    //studentList.remove(i);
    //studentList.add(i,st);
    objList.remove(i);
    objList.add(i,object);
    try {
      write.dataSave((i+1),stringBuilder.toString(),obj);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("The information of "+classname+" after change: "+objList.get(i).toString());
    count = 0;
    return true;
  }

  private static void selectStudent(List<Object> objList,String classname){
    int choose = 0;
    Scanner sc = new Scanner(System.in);
    if(objList.size()==0||objList==null){
      System.out.println("no "+classname+" be input, could not search!");
      return;
    }
    do{
      System.out.println("choose you search method, 1.select all/2.select by id");
      choose = sc.nextInt();
      switch (choose){
        case 1:
          System.out.println("select all");
          for (int i = 0; i < objList.size(); i++) {
            System.out.println("ID: "+i+"-"+objList.get(i).toString());
          }
          count = 0;
          break;
        case 2:
          System.out.println("There have "+objList.size()+" "+classname+", please input number what you want search: ");
          int i = sc.nextInt()-1;
          if(i > objList.size() || i < 0){
            System.out.println("error number");
            break;
          }
          System.out.println("The search information of "+classname+": "+objList.get(i).toString());
          count = 0;
          break;
        default:
          System.out.println("no this choose, please try again！");
          count++;
      }
    }while (count != 0);
    count = 0;
  }
}
