package practice03;

/**
 * @author YangYonggang on 2020/9/4 3:18 下午
 * @Description: 需求: 现在有一个公司 属性自定义
 * 人
 * 产品
 * 部门
 * 公司成立 boss 让 HR 招人   招生部3     研发部3个人   教学部3个人   后勤部1个
 * 增加难度:每个人都有上司
 * 完成:对 人和部门 所在的对象 增删改查
 */
public class Company {

		public static void main(String[] args) {

				EmployeeManager em = new EmployeeManager();
				// 调用添加方法，，传递的参数是一个对象实例
				em.addEmployee(new Employee(1, "张三", "男", 34, "研发部", "工程师", 34000));
				em.addEmployee(new Employee(2, "李四", "女", 32, "研发部", "技师", 9000));
				em.addEmployee(new Employee(3, "王五", "男", 26, "产品部", "经理", 24000));
				em.addEmployee(new Employee(4, "赵六", "女", 24, "后勤部", "普工", 4000));
				System.out.println("--------------------------显示所有员工信息--------------------------");
				System.out.println();
				em.listEmployee();
				System.out.println();
				System.out.println("------------------------------删除员工------------------------------");
				System.out.println();
				em.deleteEmployee(2);
				System.out.println();
				System.out.println("----------------------------查看员工信息----------------------------");
				System.out.println();
				Employee e1 = em.getEmployee(3);
				System.out.println();
				System.out.println("----------------------------更改员工信息----------------------------");
				System.out.println();
				em.updateEmployee(4, "田七", "男", 45, "研发部", "经理", 30000);

		}
}
