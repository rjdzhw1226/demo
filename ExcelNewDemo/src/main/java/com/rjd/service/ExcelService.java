package com.rjd.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

public interface ExcelService {
  public <T> List<T> creatBean(Class<T> classzz, Workbook workbook);

  public void ExcelMap(Workbook workbook);
}
