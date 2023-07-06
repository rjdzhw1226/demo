package com.digui;

import java.io.File;

public class fileSearch {
  public static void main(String[] args) {
    fileSearch(new File("D:/"),"文字文稿1.docx");
  }
  public static void fileSearch(File dir , String FileName){

    if (dir!=null&&dir.isDirectory()) {
      File[] files = dir.listFiles();

      if (files!=null&&files.length>0) {
        for (File file : files) {
          if (file.isFile()) {
            if(file.getName().contains(FileName)){
              System.out.println("找到了："+file.getAbsolutePath());
            }
          }else{
            fileSearch(file,FileName);
          }
        }
      }
    }else{
      System.out.println("不是文件夹！");
    }


  }
}
