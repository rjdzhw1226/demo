package com.rjd.controller;


import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.rjd.Utils.ExcelUtils;
import com.rjd.Utils.POIUtils;
import com.rjd.pojo.Test;
import com.rjd.pojo.User;
import com.rjd.service.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class ExcelController {
  @Autowired
  private ExcelService excelService;

  @Autowired
  private BaseMysqlCRUDManager baseMysqlCRUDManager;

  @PostMapping("/upload")
  public void importUser(@RequestParam("imgFile") MultipartFile file , @RequestParam("imgName") String name) throws Exception {

    List<User> users = ExcelUtils.readMultipartFile(file, User.class);
    for (User user : users) {
      //userMapper.insert(user);
      baseMysqlCRUDManager.save(user);
      System.out.println(user.toString());
    }
//    String originalFilename = file.getOriginalFilename();
//    String s = file.getOriginalFilename();
//    if(s.contains(".")){
//    }
//    String[] split = s.split("\\.");
//    String fileType = split[split.length-1];
//
//    String name1 = file.getName();
//    String contentType = file.getContentType();
//    System.out.println("========originalFilename: "+originalFilename);
//    System.out.println("========name1: "+name1);
//    System.out.println("========fileType: "+fileType);
    //Workbook workbook = POIUtils.getWorkBook(file);
    //excelService.ExcelMap(workbook);
//    List<User> users1 = excelService.creatBean(User.class, workbook);
  }
}
