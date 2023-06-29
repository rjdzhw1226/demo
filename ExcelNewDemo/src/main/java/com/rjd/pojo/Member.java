package com.rjd.pojo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.rjd.Utils.ExcelImport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Member")
public class Member {
  @ExcelImport("账号")
  @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
  private Integer id;
  @ExcelImport("姓名")
  @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String name;
  @ExcelImport("客商代码")
  @Column(name = "number",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String number;
  @ExcelImport("昵称")
  @Column(name = "nickName",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String nickName;
  @ExcelImport("手机号")
  @Column(name = "telephone",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String telephone;
  @ExcelImport("邮箱")
  @Column(name = "email",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String email;
  @ExcelImport("工号")
  @Column(name = "workNumber",type = MySqlTypeConstant.VARCHAR,length = 111)
  private String workNumber;
}
