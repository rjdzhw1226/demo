package com.rjd;

import com.rjd.config.MyBatisMapperScannerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ExcelNewDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExcelNewDemoApplication.class, args);
    String Path = "";
  }

}
