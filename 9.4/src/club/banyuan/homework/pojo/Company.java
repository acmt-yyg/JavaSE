package club.banyuan.homework.pojo;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/9/4 3:47 下午
 */
public class Company {

  public  Employee getBoss(){
    Employee employee = new Employee();
    employee.setEmpId("001");
    employee.setEmpName(getCOMPANY_FOR_NAME());//上司名字
    employee.setJob("老板");
    employee.setPassword("123456");

    return employee;
  }

  public String getCOMPANY_FOR_NAME() {
    return "吴楠";
  }

  private  Department[] department; //有多个部门
  private  Product product; //产品


  public Department[] getDepartment() {
    return department;
  }

  public void setDepartment(Department[] department) {
    this.department = department;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "Company{" +
        "department=" + Arrays.toString(department) +
        ", product=" + product +
        '}';
  }
}
