package practice03;

import java.util.Arrays;

/**
 * @author YangYonggang on 2020/9/4 4:48 下午
 * @Description:员工管理类
 */
public class EmployeeManager {

		private Employee[] employees = new Employee[10];     // 存放员工

		public int index = 0; // 累计添加对象的个数,表示累计数组下标即员工存放的位置

		/**
		 * 增加员工的方法
		 *
		 * @param e
		 */
		public void addEmployee(Employee e) {

				if (index >= employees.length) {
						int newLen = employees.length * 2;
						employees = Arrays.copyOf(employees, newLen);
				}
				employees[index] = e;
				index++;
		}

		/**
		 * 打印所有员工方法
		 */
		public void listEmployee() {

				for (Employee e : employees) {
						if (e != null) {
								System.out.println(e.toString());
						}
				}
		}

		/**
		 * 删除员工的方法
		 *
		 * @param id
		 */
		public Employee deleteEmployee(int id) {

				for (int i = 0; i < employees.length; i++) {
						Employee e = employees[i];
						if (e != null && e.getId() == id) {
								id = i;
						}
				}
				Employee e = employees[id];
				employees[id] = null;
				// 从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
				// (Object src,int srcPos, Object dest,int destPos, int length)
				System.arraycopy(employees, id, employees, id + 1, employees.length - (id + 1));
				index--;
				listEmployee();
				return e;
		}

		/**
		 * 查看员工的方法
		 *
		 * @param id
		 */
		public Employee getEmployee(int id) {

				for (Employee e : employees) {
						if (e != null && e.getId() == id) {
								System.out.println("工号=" + e.getId() + ", 姓名=" + e.getName() + ", 性别=" + e.getGender() + ", 年龄=" + e.getAge() + "岁" + ", 部门=" + e.getDepartment() + ", 职位=" + e.getPost() + ", 薪水=" + e.getSalary() + "元");
								return e;
						}
				}
				return null;
		}

		/**
		 * 修改员工信息的方法
		 *
		 * @param id
		 */
		public void updateEmployee(int id, String name, String gender, int age, String department, String post, double salary) {

				System.out.println("========更改前信息========");
				System.out.println();
				Employee e = this.getEmployee(id);
				if (e != null) {
						e.setName(name);
						e.setGender(gender);
						e.setAge(age);
						e.setDepartment(department);
						e.setPost(post);
						e.setSalary(salary);
						System.out.println();
						System.out.println("========更改后信息========");
						System.out.println();
						System.out.println("工号=" + e.getId() + ", 姓名=" + e.getName() + ", 性别=" + e.getGender() + ", 年龄=" + e.getAge() + "岁" + ", 部门=" + e.getDepartment() + ", 职位=" + e.getPost() + ", 薪水=" + e.getSalary() + "元");
				}
		}
}
