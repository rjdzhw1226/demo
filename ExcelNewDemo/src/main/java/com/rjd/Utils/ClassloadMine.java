package com.rjd.Utils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassloadMine {
  File file;

  public void complie2Class() {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
    Iterable units = fileMgr.getJavaFileObjects(file);
    JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
    t.call();
    try {
      fileMgr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void loadClass(String className) {
    String fileUrl = "file:/" + file.getParent();
    System.out.println(fileUrl);
    try {
      URL[] urls = new URL[]{new URL(fileUrl)};
      URLClassLoader ul = new URLClassLoader(urls, ClassLoader.getSystemClassLoader());
      java.lang.Class<?> c = ul.loadClass(getClass().getPackage().getName() + "." + className);
      System.out.println(c.newInstance().getClass().getName());
      Object o = c.newInstance();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

//    public static void main(String args[]) {
//      try {
//        URL url = new URL("file:D:/");
//        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
//        Class<?> thisClass = classLoader.loadClass("MainClass");
//        System.out.println(thisClass.getMethods()[0].getName());
//        classLoader.close();
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//    }
  /**
   * @param args
   * @throws Exception
   */
    public static void main(String[] args) throws Exception {
      while (true) {
        File filpath=new File("");
        String path = "file:"+filpath.getAbsoluteFile()+"\\src\\datas\\";
        URL newurl=new URL(path);
        URLClassLoader classLoader=new URLClassLoader(new URL[]{newurl});
        Class<?> methtClass = classLoader.loadClass("datas.bug");
        Object obj = methtClass.newInstance();
        methtClass.getDeclaredMethod("name").invoke(obj);
        System.out.println(classLoader);
        Thread.sleep(3000);
      }
    }
  }
