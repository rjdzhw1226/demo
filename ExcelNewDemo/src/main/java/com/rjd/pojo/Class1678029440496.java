package com.rjd.pojo;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.rjd.Utils.ExcelImport;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Class1678029440496")
public class Class1678029440496{
@ExcelImport("姓名")
@Column(name = "COLUM1",type = MySqlTypeConstant.VARCHAR,length = 111)
private String COLUM1;
@ExcelImport("年龄")
@Column(name = "COLUM2",type = MySqlTypeConstant.VARCHAR,length = 111)
private String COLUM2;
@ExcelImport("性别")
@Column(name = "COLUM3",type = MySqlTypeConstant.VARCHAR,length = 111)
private String COLUM3;
@ExcelImport("电话")
@Column(name = "COLUM4",type = MySqlTypeConstant.VARCHAR,length = 111)
private String COLUM4;
@ExcelImport("城市")
@Column(name = "COLUM5",type = MySqlTypeConstant.VARCHAR,length = 111)
private String COLUM5;
@ExcelImport("头像")
@Column(name = "COLUM6",type = MySqlTypeConstant.VARCHAR,length = 111)
private String COLUM6;
@ExcelImport("日期")
@Column(name = "COLUM7",type = MySqlTypeConstant.DATETIME)
private Date COLUM7;

}
