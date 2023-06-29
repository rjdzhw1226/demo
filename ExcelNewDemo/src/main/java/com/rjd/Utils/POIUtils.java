package com.rjd.Utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class POIUtils {
  private final static String DATE_FORMAT = "yyyy/MM/dd";

  public static void main(String[] args) {
//    NumberExtendExtractOrReport n = new NumberExtendExtractOrReport();
//    PhoneNumberExtendExtractOrReport n1 = new PhoneNumberExtendExtractOrReport();
//    try {
//      n1.prepareAndSendReport("D:/day01/day01_demo01/src/main/java/rjd/file/data.txt");
//
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    }
    POIUtils.close();
  }

  public static void close(){
    File f = new File("C:/Users/RJD/Desktop/工作簿1.xlsx");
    File f2 = new File("D:/WeChat/WeChat Files/wxid_h2qxya2s2vv222/FileStorage/File/2023-02/附件：2023年股份公司客户价值分类清单01.xlsx");

    File f1 = new File("C:/Users/RJD/t_iboa_business_entertain_apply.xlsx");

    Workbook workbook = null;

    NPOIFSFileSystem npoifs = null;
    OPCPackage pkg = null;
    try {
//      pkg = OPCPackage.open(f.getAbsolutePath());
//      workbook = WorkbookFactory.create(pkg);
//      if (npoifs != null) {
//        npoifs.close();
//      }
//      if (pkg != null) {
//        pkg.close();
//      }
      FileInputStream input = new FileInputStream(f);
      BufferedInputStream bufferedInputStream = new BufferedInputStream(input);
      workbook = new XSSFWorkbook(bufferedInputStream);
      List<String[]> list = new ArrayList<String[]>();


      //判断文件字节输入流是否为空
      if (input != null) {
        //sheet个数
        int numberOfSheets = workbook.getNumberOfSheets();
        //遍历sheet
        for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
          //获得当前sheet工作表
          Sheet sheet = workbook.getSheetAt(sheetNum);
          if(sheet == null){
            continue;
          }
          //获得当前sheet的开始行
          int firstRowNum  = sheet.getFirstRowNum();
          Row row1 = sheet.getRow(firstRowNum);
          Cell cell1 = row1.getCell(0);
          String Value = getCellValue(cell1);

          //获得当前sheet的结束行
          int lastRowNum = sheet.getLastRowNum();
          //循环除了第一,二行的所有行（根据格式而定）
          for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){
            //获得当前行
            Row row = sheet.getRow(rowNum);
            if(row == null){
              continue;
            }
            //获得当前行的开始列
            int firstCellNum = row.getFirstCellNum();
//            if (firstCellNum != 0){
//              firstCellNum = 0;
//            }
            //获得当前行的列数
            //int lastCellNum = row.getPhysicalNumberOfCells();
            int lastCellNum = row.getLastCellNum();
            //String[] cells = new String[row.getPhysicalNumberOfCells()];
            String[] cells = new String[row.getLastCellNum()];
            //循环当前行
            for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
              Cell cell = row.getCell(cellNum);
              cells[cellNum] = getCellValue(cell);
              getCellStyle(cell);
            }
            list.add(cells);
          }

        }
        input.close();
        //pkg.close();
        int i = 0;
        for (String[] strings : list) {
          String Type = strings[0];
          String Id = strings[2];
          i++;
          System.out.println(String.valueOf(i)+":用户代码："+Id+"类型："+Type);
        }
      }
    } catch(Exception ofe) {
      ofe.printStackTrace();
    }



  }
  public static String getCellStyle(Cell cell){
    String cellValue = "";
    switch (cell.getCellTypeEnum()) {
      case STRING:
        cellValue = "string";
        break;
      case NUMERIC:
        if("General".equals(cell.getCellStyle().getDataFormatString())){
          cellValue = "dateForm";
        }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
          cellValue = "dateForm";
        }else{
          cellValue = "bigInt";
        }
        break;
      case BOOLEAN:
        cellValue = "boolean";
        break;
      case BLANK:
        cellValue = "";
        break;
      default:
        cellValue = "defaultString";
        break;
    }
    return cellValue;
  }

  public static Workbook getWorkBook(MultipartFile file) {
    //获得文件名
    String fileName = file.getOriginalFilename();
    //创建Workbook工作薄对象，表示整个excel
    Workbook workbook = null;
    try {
      //获取excel文件的io流
      InputStream is = file.getInputStream();
      //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
      if(fileName.endsWith("xls")){
        //2003
        workbook = new HSSFWorkbook(is);
      }else if(fileName.endsWith("xlsx")){
        //2007
        workbook = new XSSFWorkbook(is);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return workbook;
  }
  public static String getCellValue(Cell cell){
    String cellValue = "";
    if(cell == null){
      return cellValue;
    }
    //如果当前单元格内容为日期类型，需要特殊处理
    String dataFormatString = cell.getCellStyle().getDataFormatString();
    if(dataFormatString.equals("m/d/yy")){
      cellValue = new SimpleDateFormat(DATE_FORMAT).format(cell.getDateCellValue());
      return cellValue;
    }
    //把数字当成String来读，避免出现1读成1.0的情况
    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
      cell.setCellType(Cell.CELL_TYPE_STRING);
    }
    //判断数据的类型
    switch (cell.getCellType()){
      case Cell.CELL_TYPE_NUMERIC: //数字
        cellValue = String.valueOf(cell.getNumericCellValue());
        break;
      case Cell.CELL_TYPE_STRING: //字符串
        cellValue = String.valueOf(cell.getStringCellValue());
        break;
      case Cell.CELL_TYPE_BOOLEAN: //Boolean
        cellValue = String.valueOf(cell.getBooleanCellValue());
        break;
      case Cell.CELL_TYPE_FORMULA: //公式
        cellValue = String.valueOf(cell.getCellFormula());
        break;
      case Cell.CELL_TYPE_BLANK: //空值
        cellValue = "";
        break;
      case Cell.CELL_TYPE_ERROR: //故障
        cellValue = "非法字符";
        break;
      default:
        cellValue = "未知类型";
        break;
    }
    return cellValue;
  }
}

