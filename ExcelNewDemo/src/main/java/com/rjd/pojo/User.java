package com.rjd.pojo;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.rjd.Utils.ExcelImport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

  private static final long serialVersionUID = 5199200306752426433L;
  @ExcelImport("姓名")
  @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String name;
  @ExcelImport("年龄")
  @Column(name = "age",type = MySqlTypeConstant.INT,length = 11)
  private Integer age;
  @ExcelImport("性别")
  @Column(name = "sex",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String sex;
  @ExcelImport("电话")
  @Column(name = "tel",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String tel;
  @ExcelImport("城市")
  @Column(name = "city",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String city;
  @ExcelImport("头像")
  @Column(name = "avatar",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String avatar;


}
