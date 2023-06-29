package com.rjd.Utils;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
/**
 * 动态生成类以及编译，JDK版本必须要在1.6，或者1.6以上
 */
public class CompilerTest {

  //回车加换行符
  static String rt = "\r\n";
  //生成类的源文件，写成字符串的形式
  static String src =
    "package com.rjd.pojo;"+ rt +
      "public class HelloWorld  {" + rt +
      "    public static void main(String[] args) {" + rt +
      "         System.out.println(\"Hello world!\");" + rt +
      "    }" + rt +
      "}";

  public static void main (String[] args) throws Exception {

    StringBuilder sb = new StringBuilder();
    long i = System.currentTimeMillis();
    //写文件，目录可以自己定义
    String filename = "D:/day01/ExcelNewDemo/src/main/java/com/rjd/pojo/"+"Class"+i+".java";
    sb.append("@ExcelImport(\""+ "任嘉冬" +"\")");
    System.out.println(filename);
//    //写文件，目录可以自己定义
//    String filename = "D:/day01/ExcelNewDemo/src/main/java/com/rjd/pojo/HelloWorld.java";
//    //String filename = System.getProperty ("user.dir") + "/src/HelloWorld.java";
//    //System.out.println (filename);
//    File file = new File (filename);
//    FileWriter fw = new FileWriter (file);
//    fw.write(src);
//    fw.flush();
//    fw.close();

//    //编译文件,调用jdk本身的工具
//    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//    System.out.println(compiler.getClass().getName());
//
//    StandardJavaFileManager sjfm = compiler.getStandardFileManager (null, null, null);
//    Iterable units = sjfm.getJavaFileObjects (filename);
//    CompilationTask ct = compiler.getTask (null, sjfm, null, null, null, units);
//    // 动态编译可执行的代码
//    ct.call();
//    Class<?> clazz = Class.forName("com.rjd.HelloWorld");
//    try {
//      // 生成对象
//      Object obj = clazz.newInstance();
//      Class<? extends Object> cls = obj.getClass();
//      // 调用main方法
//      Method m = clazz.getMethod("main",String[].class);
//      Object invoke = m.invoke(obj, new Object[] { new String[] {} });
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    sjfm.close();
  }
}
