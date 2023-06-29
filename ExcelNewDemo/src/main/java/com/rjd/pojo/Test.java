package com.rjd.pojo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.rjd.Utils.ExcelImport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test")
public class Test extends BaseModel {

  private static final long serialVersionUID = 5199200306752426433L;

  @ExcelImport("序号")
  @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
  private Integer id;
  @ExcelImport("姓名")
  @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String  name;
  @ExcelImport("描述")
  @Column(name = "description",type = MySqlTypeConstant.TEXT)
  private String  description;
  @ExcelImport("创建日期")
  @Column(name = "create_time",type = MySqlTypeConstant.DATETIME)
  private Date    create_time;
  @ExcelImport("修改日期")
  @Column(name = "update_time",type = MySqlTypeConstant.DATETIME)
  private Date    update_time;
  @ExcelImport("学号")
  @Column(name = "number",type = MySqlTypeConstant.BIGINT,length = 5)
  private Long    number;
  @ExcelImport("生命周期")
  @Column(name = "lifecycle",type = MySqlTypeConstant.CHAR,length = 1)
  private String  lifecycle;
  @ExcelImport("职级")
  @Column(name = "dekes",type = MySqlTypeConstant.DOUBLE,length = 5,decimalLength = 2)
  private Double  dekes;

  //省略Setter、Getter

}
