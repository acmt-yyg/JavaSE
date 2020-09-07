package practice03;

/**
 * @author YangYonggang on 2020/9/4 3:32 下午
 * @Description:员工类
 */
public class Employee {

		private int id;         // 编号
		private String name;       // 姓名
		private String gender;     // 性别
		private double age;        // 年龄
		private String department; // 部门
		private String post;       // 职位
		private double salary;     // 薪水

		public Employee() {
		}

		public Employee(int id, String name, String gender, double age, String department, String post, double salary) {
				this.id = id;
				this.name = name;
				this.gender = gender;
				this.age = age;
				this.department = department;
				this.post = post;
				this.salary = salary;
		}

		public int getId() {
				return id;
		}

		public void setId(int id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public String getGender() {
				return gender;
		}

		public void setGender(String gender) {
				this.gender = gender;
		}

		public double getAge() {
				return age;
		}

		public void setAge(double age) {
				this.age = age;
		}

		public String getDepartment() {
				return department;
		}

		public void setDepartment(String department) {
				this.department = department;
		}

		public String getPost() {
				return post;
		}

		public void setPost(String post) {
				this.post = post;
		}

		public double getSalary() {
				return salary;
		}

		public void setSalary(double salary) {
				this.salary = salary;
		}

		@Override
		public String toString() {
				return "Employee{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				", department='" + department + '\'' +
				", post='" + post + '\'' +
				", salary=" + salary +
				'}';
		}
}
