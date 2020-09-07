package practice03;

/**
 * @author YangYonggang on 2020/9/4 3:32 下午
 * @Description:部门类
 */
public class Department {

		private String personnelDepartment; // 人事部
		private String rdDepartment;        // 研发部
		private String educationDepartment; // 教学部
		private String logisticsDepartment; // 后勤部

		public String getPersonnelDepartment() {
				return personnelDepartment;
		}

		public void setPersonnelDepartment(String personnelDepartment) {
				this.personnelDepartment = personnelDepartment;
		}

		public String getRdDepartment() {
				return rdDepartment;
		}

		public void setRdDepartment(String rdDepartment) {
				this.rdDepartment = rdDepartment;
		}

		public String getEducationDepartment() {
				return educationDepartment;
		}

		public void setEducationDepartment(String educationDepartment) {
				this.educationDepartment = educationDepartment;
		}

		public String getLogisticsDepartment() {
				return logisticsDepartment;
		}

		public void setLogisticsDepartment(String logisticsDepartment) {
				this.logisticsDepartment = logisticsDepartment;
		}
}
