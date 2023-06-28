package com.readexcel.controller;

import com.readexcel.Service.ReadExcelService;
import com.readexcel.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;

@Controller
@RequestMapping("/All")
public class ReadExcelController {
  @Value("${file.setPath}")
  private String setFilePath;
  @Autowired
  private User user;
  @Autowired
  private ReadExcelService service;

  @RequestMapping("/read")
  public void readFile(){
    Field[] fields = user.getClass().getDeclaredFields();
    int i = fields.length+1;
    long lBefore = System.currentTimeMillis();
    service.read(i);
    service.insert(setFilePath);
    long lAfter = System.currentTimeMillis();
    System.out.println(lAfter-lBefore);
  }
}
