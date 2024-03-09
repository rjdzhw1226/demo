//package student;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Objects;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class student implements Cloneable {
//  private String classname;
//  private String name;
//  private String id;
//  private Integer age;
//  private String address;
//
//  @Override
//  protected Object clone() throws CloneNotSupportedException {
//    return super.clone();
//  }
//
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    student student = (student) o;
//    return Objects.equals(classname, student.classname) && Objects.equals(name, student.name) && Objects.equals(id, student.id) && Objects.equals(age, student.age) && Objects.equals(address, student.address);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(classname, name, id, age, address);
//  }
//}
