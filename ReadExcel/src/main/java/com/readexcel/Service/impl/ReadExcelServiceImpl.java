package com.readexcel.Service.impl;

import com.readexcel.Dao.mapper.UserMapper;
import com.readexcel.Service.ReadExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadExcelServiceImpl implements ReadExcelService {

  @Autowired
  private UserMapper userMapper;

  @Value("${file.readPath}")
  private String readFilePath;

  @Value("${file.setPath}")
  private String setFilePath;
  @Override
  public void read(int ZiDuanNumber) {
    FileWriter fw = null;
    try {

      File fileTxt = new File(setFilePath);
      FileInputStream file = new FileInputStream(readFilePath);

      InputStreamReader read = new InputStreamReader(file,"GBK");
      BufferedReader bufferedReader = new BufferedReader(read);

      fw = new FileWriter(fileTxt, true);
      PrintWriter pw = new PrintWriter(fw);
      String str = "";
      StringBuilder ZiDuanNumberString = new StringBuilder();
      for (int i = 0; i < ZiDuanNumber - 1; i++) {
        ZiDuanNumberString.append(",");
      }
      String NumberString = ZiDuanNumberString.toString();
      while ((str = bufferedReader.readLine()) != null){
        if (fileTxt == null || fileTxt.length()==0) {
          while(str.equals(NumberString)){
            str = bufferedReader.readLine();
          }
          List<String> stringList = new ArrayList<>();
          for (String s : str.split(",")) {
            if (s == null || s.equals("")) {
              s = "空";
              stringList.add(s);
            }else{
              stringList.add(s);
            }
          }
          stringList.remove(stringList.size()-1);
          pw.println(stringList.toString().substring(1,stringList.toString().length()-1));
        }else{
          while(str.equals(NumberString)){
            str = bufferedReader.readLine();
          }
          List<String> stringList = new ArrayList<>();
          for (String s : str.split(",")) {
            if (s == null || s.equals("")) {
              s = "空";
              stringList.add(s);
            }else{
              stringList.add(s);
            }
          }
          stringList.remove(stringList.size()-1);
          System.lineSeparator();
          pw.println(stringList.toString().substring(1,stringList.toString().length()-1));
        }
      }
      pw.flush();
      fw.flush();
      pw.close();
      fw.close();
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  @Override
  public void insert(String path) {
    System.out.println("数据库加载开始执行");
    userMapper.load_file(path);
  }
}
