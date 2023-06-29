package com.rjd.service.impl;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.rjd.Utils.ExcelImport;
import com.rjd.Utils.POIUtils;
import com.rjd.service.ExcelService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExcelServiceImpl implements ExcelService {

  private final static String COLUM_FORMAT = "COLUM";
  //回车加换行符
  static String rt = "\r\n";
  @Override
  public <T> List<T> creatBean(Class<T> classzz, Workbook workbook) {
    Sheet sheet = workbook.getSheetAt(0);

    //获取最后一行
    int lastRowNum = sheet.getLastRowNum()+1;
    //获取最后一列
    int lastCellNum = sheet.getRow(0).getLastCellNum();
    //获取实体类字段
    Field[] fields = classzz.getDeclaredFields();

    Row row = null;

    List<String> headList = new ArrayList<>();

    //一行存为一个Obj,放在List中
    List<T> beans = new ArrayList<T>();

    //获取表头放在list中
    for (int j=0;j<lastCellNum;j++){
      row = sheet.getRow(0);
      Cell cell = row.getCell(j);
      //均格式化为字符串
      DataFormatter formatter = new DataFormatter();
      String value = formatter.formatCellValue(cell);
      headList.add(value);
    }

  try{
      for (int i=1;i<lastRowNum;i++){

        //通过class创建实体对象
        T instance = classzz.newInstance();
        for (int j=0;j<lastCellNum;j++){

          row = sheet.getRow(i);
          Cell cell = row.getCell(j);
          DataFormatter formatter = new DataFormatter();
          String value = formatter.formatCellValue(cell);

          String headName = headList.get(j);

          for (Field field : fields){

            if (headName.equalsIgnoreCase(field.getName())){

              String methodName = MethodUtils.setMethodName(field.getName());
              Method method = classzz.getMethod(methodName,field.getType());
              //注入值
              method.invoke(instance,value);
            }

          }

        }

        beans.add(instance);

    }
  }catch(Exception e){
    e.printStackTrace();
  }
    return beans;

  }
  @Override
  public void ExcelMap(Workbook workbook){
    //sheet个数
    int numberOfSheets = workbook.getNumberOfSheets();
    if(numberOfSheets == 1){
      //创建集合存储
      List<Map<String,String>> list = new ArrayList<>();
      Map<String,String> map = new HashMap<>();
      //获得当前sheet工作表
      Sheet sheet = workbook.getSheetAt(0);
      if(sheet == null){
        return;
      }
      //获得当前sheet的开始行
      int firstRowNum  = sheet.getFirstRowNum();
      //获得当前行
      Row row = sheet.getRow(firstRowNum);
      if(row == null){
        return;
      }
      //获得当前行的开始列
      int firstCellNum = row.getFirstCellNum();
      //获得当前行的列数
      int lastCellNum = row.getLastCellNum();
      //循环当前行
      int i = 1;
      for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
        Cell cell = row.getCell(cellNum);
        String cellValue = POIUtils.getCellValue(cell);
        if (!"null".equals(cellValue)){
          map.put(COLUM_FORMAT+i, cellValue);
          i++;
        }
      }
      list.add(map);
      Compiler(list);
    }
    else{
      //遍历sheet
      for(int sheetNum = 0;sheetNum < numberOfSheets;sheetNum++){
        //创建集合存储
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        //获得当前sheet工作表
        Sheet sheet = workbook.getSheetAt(sheetNum);
        if(sheet == null){
          continue;
        }
        //获得当前sheet的开始行
        int firstRowNum  = sheet.getFirstRowNum();
        //获得当前行
        Row row = sheet.getRow(firstRowNum);
        if(row == null){
          continue;
        }
        //获得当前行的开始列
        int firstCellNum = row.getFirstCellNum();
        //获得当前行的列数
        int lastCellNum = row.getLastCellNum();
        //循环当前行
        int i = 1;
        for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
          Cell cell = row.getCell(cellNum);
          String cellValue = POIUtils.getCellValue(cell);
          if (!"null".equals(cellValue)){
            map.put(COLUM_FORMAT+i, cellValue);
            i++;
          }
        }
        list.add(map);
        Compiler(list);
      }
    }
  }
  public static void Compiler(List<Map<String, String>> list) {
    StringBuilder str = new StringBuilder();
    long i = System.currentTimeMillis();
    //写文件，目录可以自己定义
    String filename = "D:/day01/ExcelNewDemo/src/main/java/com/rjd/pojo/"+"Class"+i+".java";
    for (int j = 0; j < list.get(0).size(); j++) {
      String cellValue = list.get(0).get("COLUM" + (j + 1));
      str.append("@ExcelImport(\""+cellValue+"\")");
      str.append("\r\n");
      if("日期".equals(cellValue)){
        str.append("@Column(name = \""+"COLUM" + (j + 1)+"\",type = MySqlTypeConstant.DATETIME)");
        str.append("\r\n");
        str.append("private Date "+"COLUM"+(j+1)+";");
        str.append("\r\n");
      }else {
        str.append("@Column(name = \""+"COLUM" + (j + 1)+"\",type = MySqlTypeConstant.VARCHAR,length = 111)");
        str.append("\r\n");
        str.append("private String "+"COLUM"+(j+1)+";");
        str.append("\r\n");
      }
    }
    String src =
      "package com.rjd.pojo;"+ rt +
        "import com.gitee.sunchenbin.mybatis.actable.annotation.Column;"+ rt +
        "import com.gitee.sunchenbin.mybatis.actable.annotation.Table;"+ rt +
        "import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;"+ rt +
        "import com.rjd.Utils.ExcelImport;"  + rt +
        "import lombok.AllArgsConstructor;"  + rt +
        "import lombok.NoArgsConstructor;"  + rt +
        "import lombok.Builder;"  + rt +
        "import lombok.Data;"  + rt +
        "import java.util.Date;"  + rt +
        "@Data" + rt +
        "@Builder" + rt +
        "@AllArgsConstructor" + rt +
        "@NoArgsConstructor" + rt +
        "@Table(name = \""+"Class"+i+"\")" + rt +
        "public class Class"+ i +"{" + rt +
        str.toString() + rt +
        "}";
    File file = new File (filename);
    FileWriter fw = null;
    try {
      fw = new FileWriter(file);
      fw.write(src);
      fw.flush();
      fw.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  //内部静态类
  static class MethodUtils {
    private static final String SET_PREFIX = "set";
    private static final String GET_PREFIX = "get";
    private static String capitalize(String name) {
      if (name == null || name.length() == 0) {
        return name;
      }
      //set+首字母大写 比如setSid
      return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    public static String setMethodName(String propertyName) {
      return SET_PREFIX + capitalize(propertyName);
    }
    public static String getMethodName(String propertyName) {
      return GET_PREFIX + capitalize(propertyName);
    }
  }
}
