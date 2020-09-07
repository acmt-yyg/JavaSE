package club.banyuan.homework.pojo;

/**
 * 员工类
 *
 * @author sanye
 * @version 1.0
 * @date 2020/9/4 3:47 下午
 */
public class Employee {
		/**
		 * 员工信息
		 */
		private String empId;
		private String empName; //员工名称
		private String job; //工作
		private Employee emp;//上司  可以选择只要上司的id
		private String deName;//属于哪个部门
		private String password; //员工登录的密码

		public String getPassword() {
				return password;
		}

		public void setPassword(String password) {
				this.password = password;
		}

		public String getEmpId() {
				return empId;
		}

		public void setEmpId(String empId) {
				this.empId = empId;
		}

		public String getEmpName() {
				return empName;
		}

		public void setEmpName(String empName) {
				this.empName = empName;
		}

		public String getJob() {
				return job;
		}

		public void setJob(String job) {
				this.job = job;
		}

		public Employee getEmp() {
				return emp;
		}

		public void setEmp(Employee emp) {
				this.emp = emp;
		}

		public String getDeName() {
				return deName;
		}

		public void setDeName(String deName) {
				this.deName = deName;
		}

		@Override
		public String toString() {
				return "Employee{" +
				"empId='" + empId + '\'' +
				", empName='" + empName + '\'' +
				", job='" + job + '\'' +
				", 上司是='" + emp.getEmpName() + '\'' +
				", 属于='" + deName + '\'' +
				'}';
		}
}
