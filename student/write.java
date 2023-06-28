package student;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.util.List;

public class write {
  public static Boolean readFile(String login,String pass){
    String line = "";
    Boolean ob = false;
    try {
      File file = new File("D:/day01/lianxi02/src/main/java/student/Login.txt");
      BufferedReader br = new BufferedReader(new FileReader(file));
      while ((line = br.readLine())!=null){
        if(login.equals(line.split(":")[0])){
          if(pass.equals(line.split(":")[1])){
            ob = true;
          }else {
            ob = false;
          }
        }
      }
    }catch (Exception e){
      e.printStackTrace();
    }
    return ob;
  }
  public static Object dataCh(int i,Object obj){
    //修改后台文件数据
    //student st = new student();
    Object ob = new Object();
    try {
      File file = new File("D:/day01/lianxi02/src/main/java/student/"+obj.getClass().getSimpleName()+"Test.txt");
      BufferedReader br = new BufferedReader(new FileReader(file));
      String lin = "";
      int count = 0;
      while ((lin = br.readLine())!=null){
        count++;
        if(count == i){
          ob = JSON.parseObject(lin, Object.class);
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return ob;
  }

  public static void dataSave(int i,String str,Object obj) throws Exception {
    File f=new File("D:/day01/lianxi02/src/main/java/student/"+obj.getClass().getSimpleName()+"Test.txt");
    File newFile = new File(f.getAbsolutePath() + ".tmp");
    if (!newFile.exists()){
      newFile.createNewFile();
    }else{
      System.out.println("File already exists(create file already done)");
    }
    BufferedReader br = new BufferedReader(new FileReader(f));
    PrintWriter pw = new PrintWriter(new FileWriter(newFile));
    String lin01 = null;
    int count = 0;
    while ((lin01 = br.readLine())!=null){
      count++;
      if(count == i){
        lin01 = str;
        pw.println(lin01);
        pw.flush();
      }else{
        pw.println(lin01);
        pw.flush();
      }
    }
    pw.close();
    br.close();
    copyFileUsingFileChannels(newFile,f);
  }
  public static void method1(student content) {
    FileWriter fw = null;
    try {
      //如果文件存在，则追加内容；如果文件不存在，则创建文件
    File f=new File("D:/day01/lianxi02/src/main/java/student/Data.txt");
    fw = new FileWriter(f, true);

    PrintWriter pw = new PrintWriter(fw);
    if (f == null || f.length()==0) {
      pw.println(JSON.toJSONString(content));
    }else{
      System.lineSeparator();
      pw.println(JSON.toJSONString(content));
    }
    pw.flush();
    fw.flush();
    pw.close();
    fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void delFile(int lineNumber,String classname) throws Exception {
    File f=new File("D:/day01/lianxi02/src/main/java/student/"+classname+"Test.txt");
    File newFile = new File(f.getAbsolutePath() + ".tmp");
    BufferedReader br = new BufferedReader(new FileReader(f));
    PrintWriter pw = new PrintWriter(new FileWriter(newFile));

    String lineStr = null;//某一行的值
    int lineCount = 0;//行数
    while ((lineStr = br.readLine()) != null) {
      lineCount++;
      if (lineCount != lineNumber) {
        pw.println(lineStr);
        pw.flush();
      }
    }
    pw.close();
    br.close();
    copyFileUsingFileChannels(newFile,f);
  }

  private static void copyFileUsingFileChannels(File source, File dest) throws IOException {
    //复制文件方法
    FileChannel inputChannel = null;
    FileChannel outputChannel = null;
    try {
      inputChannel = new FileInputStream(source).getChannel();
      outputChannel = new FileOutputStream(dest).getChannel();
      outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
    } finally {
      inputChannel.close();
      outputChannel.close();
    }
  }

  public static void get(String JsonStr){
    try {
      Object object = JSON.parseObject(JsonStr);
      Class c = object.getClass();
      String objAddress = c.getSimpleName();
      System.out.println(objAddress);
      Field[] fields = c.getDeclaredFields();
      for (Field field : fields) {
        String name = field.getName();
        field.setAccessible(true);
        String s = field.get(object) + "";
        System.out.print(name+":"+s+", ");
        System.out.println();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Object writeString(List<String> list,String name,List<Object> objList) throws Exception{
    FileWriter fw = null;

    File f=new File("D:/day01/lianxi02/src/main/java/student/"+name+"Test.txt");
    fw = new FileWriter(f, true);

    StringBuilder sConcat = new StringBuilder();

    sConcat.append("{");

    for (int i = 0; i < list.size() ; i++) {
      sConcat.append(list.get(i));
      if(i != list.size()-1){
        sConcat.append(",");
      }
    }
    sConcat.append("}");
    String s = sConcat.toString();

    Object object = JSON.parseObject(s, Object.class);


    objList.add(object);

    PrintWriter pw = new PrintWriter(fw);
    if (f == null || f.length()==0) {
      pw.println(s);
    }else{
      System.lineSeparator();
      pw.println(s);
    }
    pw.flush();
    fw.flush();
    pw.close();
    fw.close();
    return object;
  }
}
