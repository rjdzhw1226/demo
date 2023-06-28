package student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class teacher {
  private String classname;
  private String name;
  private String salary;
  private Integer age;
  private String subject;

}
