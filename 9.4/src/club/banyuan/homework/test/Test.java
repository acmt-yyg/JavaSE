package club.banyuan.homework.test;

import club.banyuan.homework.pojo.Company;
import club.banyuan.homework.pojo.Department;
import club.banyuan.homework.pojo.Employee;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/9/4 4:05 下午
 */
public class Test {


		public static void main(String[] args) {
				Company company = new Company();//创建一个公司
				Department[] departments = new Department[3];
				System.out.println("欢迎来到半圆人事管理系统~");
				boolean flag = false;
				Scanner scanner = new Scanner(System.in);

				loop1:
				while (true) {
						System.out.println("请你进行选项操作:\t1.登录\t2.退出");
						String str = scanner.next();
						if (str.equals("1")) {
								int count = 3;
								while (count > 0) {
										Employee emp = new Employee();
										System.out.println("请输入员工编号:");
										String id = scanner.next();
										System.out.println("请输入密码:");
										String password = scanner.next();
										emp.setEmpId(id);
										emp.setPassword(password);

										emp = login(emp, departments, company);//如果登录就继续进行下一步,如果没有登录就重新登录

										if (emp != null) {
												switch (emp.getJob()) {
														case "老板": //老板只需要招一个人事就行
																System.out.println("欢迎老板登录...");
																Employee employee = new Employee();
																employee.setEmpId("9520");
																employee.setEmpName("王轩");
																employee.setJob("人事主管");
																employee.setDeName("人事部");
																employee.setPassword("123456");
																employee.setEmp(company.getBoss());//设置上司

																createDepartment(departments, new String[]{"人事部", "研发部", "教学部"});//创建部门
																company.setDepartment(departments);

																addEmploy(employee, departments);
																System.out.println("人事已经找到...部门已经创好...等待招人中...");

																continue loop1;

														case "人事主管":
																while (true) {
																		System.out.println("您接下来做什么？\t1.增加员工\t2.修员工信息\t3.删除员工信息\t4.显示员工信息\t5.退出");
																		System.out.println("请输入操作...");
																		String next = scanner.next();
																		if (next.equals("5")) {
																				continue loop1;
																		}
																		HRMethod(next, departments, company);
																}
														case "讲师主管":

																break;
														case "研发主管":

																break;
														default:

																break;

												}


										} else {
												System.out.println("没有这个人,请重新输入....");
												count--;
												if (count == 0) {
														System.out.println("输入三次密码不正确,强制退出...");
														System.exit(0);
												}
										}
								}


						} else if (str.equals("2")) {
								break;
						} else {
								System.out.println("没有此选项");
						}
				}

				for (int i = 0; i < company.getDepartment().length; i++) {
						System.out.println(company.getDepartment()[i].toString());
				}
		}

		/**
		 * 添加员工方法
		 *
		 * @param employee
		 * @param departments
		 */
		public static Employee login(Employee employee, Department[] departments, Company company) {
				if (departments == null) {
						System.err.println("没有部门");
						return null;
				}
				if (employee.getEmpId().equals(company.getBoss().getEmpId()) &&
				employee.getPassword().equals(company.getBoss().getPassword())) {
						return company.getBoss();
				}
				for (int i = 0; i < departments.length; i++) {
						if (departments[i] != null) {
								Employee[] employees = departments[i].getEmployees();
								for (Employee e : employees) {
										if (employee.getEmpId().equals(e.getEmpId()) && employee.getPassword()
										.equals(e.getPassword())) {
												return e;
										}
								}
						}

				}

				return null;
		}

		//这是人事的功能
		public static void addEmploy(Employee employee, Department[] departments) {
				System.out.println("调用添加员工方法");
				Employee[] employees = null; //
				for (int i = 0; i < departments.length; i++) {
						if (employee.getDeName().equals(departments[i].getDeptName())) {
								//首先判断部门里面有没有人
								if (departments[i].getEmployees() == null) {
										employees = new Employee[1];
										employees[0] = employee;
										departments[i].setEmployees(employees);
								} else {
										//如果不为空就要进行数组扩容
										employees = new Employee[departments[i].getEmployees().length + 1];
										for (int j = 0; j < departments[i].getEmployees().length; j++) {
												employees[j] = departments[i].getEmployees()[j];
										}
										employees[departments[i].getEmployees().length] = employee;
										departments[i].setEmployees(employees);
								}
						}
				}
		}


		//这个也是人事的功能
		public static void createDepartment(Department[] departments, String[] strings) {

				for (int i = 0; i < strings.length; i++) {
						Department department = new Department();
						department.setDeptId("100" + (1 + i));
						department.setDeptName(strings[i]);
						departments[i] = department;
				}

		}


		//对员工的增删改查 只有老板有这个权限或者直属上司
		public static void deleteEmploy(Employee employee, Company company) { //删除哪个员工
				Department[] department = company.getDepartment();//
				for (int i = 0; i < department.length; i++) {
						Employee[] employees = department[i].getEmployees();
						for (int j = 0; j < employees.length; j++) {
								if (employees[j].getEmpId().equals(employee.getEmpId())) {
										//如果删除的是主管那么对应主管下面的所有的人都没有上司 上司都是null
										employees = deleteEmployFinal(employees[j], employees);
										department[i].setEmployees(employees);

								}
						}
				}
		}

		public static Employee[] deleteEmployFinal(Employee employee, Employee[] employees) {

				int index = -1; //要删除人的位置
				Employee[] es = new Employee[employees.length - 1];
				for (int i = 0; i < employees.length; i++) {
						if (employees[i].getEmpId().equals(employee.getEmpId())) {
								index = i;//找到了
						}
				}

				if (employee.getJob().endsWith("主管")) {
						ArrayMoveLeader(index, employees, es);
				} else {  //如果不是主管
						ArrayMove(index, employees, es);
				}


    /*for (int i = 0; i < es.length; i++) {
      System.out.println(es[i].toString());
    }
*/

				return es;
		}

		//删除普通员工
		public static void ArrayMove(int index, Employee[] employees, Employee[] es) {
				for (int i = index; i < employees.length; i++)
						if (i != employees.length - 1) {
								employees[i] = employees[i + 1];
						} else {
								employees[i] = null;
						}
				//主管删除完了  多余了一个空位
				for (int i = 0; i < es.length; i++) {
						assert employees[i] != null;
						es[i] = employees[i];
				}
		}

		//删除主管
		public static void ArrayMoveLeader(int index, Employee[] employees, Employee[] es) {
				for (int i = index; i < employees.length; i++) {
						if (i != employees.length - 1) {
								employees[i] = employees[i + 1];
						} else {
								employees[i] = null;
						}
				}
				//主管删除完了  多余了一个空位
				for (int i = 0; i < es.length; i++) {
						assert employees[i] != null;
						Employee em = employees[i];
						Employee emp = em.getEmp();
						emp.setEmpName(null);
						em.setEmp(emp);
						es[i] = em;
				}
		}


		public static void showEmployee(Company company) {
				Department[] department = company.getDepartment();
				for (int i = 0; i < department.length; i++) {
						for (int j = 0; j < department[i].getEmployees().length; j++) {
								System.out.println(department[i].getEmployees()[j].toString());
						}
				}
		}

		/**
		 * 人事操作的方法
		 *
		 * @param next        人事操作命令
		 * @param departments 部门数组
		 * @param company     公司
		 */
		public static void HRMethod(String next, Department[] departments, Company company) {
				System.out.println("欢迎人事登录...");
				switch (next) {
						case "1":
								Employee employee2 = new Employee();
								employee2.setEmpId("9521");
								employee2.setEmpName("林川");
								employee2.setJob("讲师主管");
								employee2.setDeName("教学部");
								employee2.setEmp(company.getBoss());  //设置上司
								employee2.setPassword("123456");
								addEmploy(employee2, departments);

								//System.out.println(company.getDepartment()[0].toString());
								Employee employee3 = new Employee();
								employee3.setEmpId("9523");
								employee3.setEmpName("周健");
								employee3.setJob("讲师");
								employee3.setDeName("教学部");
								employee3.setEmp(employee2);
								employee3.setPassword("123456");
								addEmploy(employee3, departments);

								Employee emp = new Employee();
								emp.setEmpId("9527");
								emp.setEmpName("未知");
								emp.setJob("讲师");
								emp.setDeName("教学部");
								emp.setEmp(employee2);
								emp.setPassword("123456");
								addEmploy(emp, departments);

								Employee employee4 = new Employee();
								employee4.setEmpId("9524");
								employee4.setEmpName("王五");
								employee4.setJob("研发");
								employee4.setDeName("研发部");
								employee4.setEmp(company.getBoss());
								employee4.setPassword("123456");
								addEmploy(employee4, departments);

								Employee employee5 = new Employee();
								employee5.setEmpId("9525");
								employee5.setEmpName("赵六");
								employee5.setJob("研发");
								employee5.setDeName("研发部");
								employee5.setEmp(company.getBoss());
								employee5.setPassword("123456");
								addEmploy(employee5, departments);
								break;
						case "2":

								break;
						case "3":
								Employee employee = new Employee();
								employee.setEmpId("9527");
								deleteEmploy(employee, company);
								break;

						case "4":
								showEmployee(company);
								break;
						case "5":

								break;
						default:
								break;


				}

		}


		//TODO 你们可以尝试去做 讲师主管的功能 可以参考人事功能


}
