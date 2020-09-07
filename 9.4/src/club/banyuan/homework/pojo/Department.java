package club.banyuan.homework.pojo;

import java.util.Arrays;

/**
 * 部门类
 *
 * @author sanye
 * @version 1.0
 * @date 2020/9/4 3:47 下午
 */
public class Department {

		private String deptId;
		private String deptName;
		private Employee[] employees;

		@Override
		public String toString() {
				return "Department{" +
				"deptId='" + deptId + '\'' +
				", deptName='" + deptName + '\'' +
				", employees=" + Arrays.toString(employees) +
				'}';
		}

		public String getDeptId() {
				return deptId;
		}

		public void setDeptId(String deptId) {
				this.deptId = deptId;
		}

		public String getDeptName() {
				return deptName;
		}

		public void setDeptName(String deptName) {
				this.deptName = deptName;
		}

		public Employee[] getEmployees() {
				return employees;
		}

		public void setEmployees(Employee[] employees) {
				this.employees = employees;
		}
}
