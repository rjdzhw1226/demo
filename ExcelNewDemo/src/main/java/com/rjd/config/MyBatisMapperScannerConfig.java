package com.rjd.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(TestConfig.class)
public class MyBatisMapperScannerConfig {

  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() throws Exception{
    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setBasePackage("com.rjd.dao.mappers.*;com.gitee.sunchenbin.mybatis.actable.dao.*");
    mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    return mapperScannerConfigurer;
  }

}