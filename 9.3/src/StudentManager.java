import java.util.Scanner;

/**
 * 作业3：设计一个：学生管理系统
 * 1.添加学生信息\n
 * 2.显示学生信息\n    显示所有学生信息
 * 3.删除学生信息\n   根据学生id删除学生信息
 * 4.修改学生信息\n   根据学生id修改学生信息
 * 5.查看学生信息\n   查看的条件自定义
 * 6.排序\n  （请选择排序方法:1.按学号排序\t2.按成绩排序）
 * 7.退出
 * 学生信息有 学生id  学生姓名stuName  学生成绩stuScore (使用数组存储数据)
 * 完成上述要求
 *
 * @author YangYonggang on 2020/9/3
 */
public class StudentManager {

		/**
		 * 测试用例
		 * @param args
		 */
		public static void main(String[] args) {

				Student[] arr = new Student[10];

				while (true) {
						System.out.println("=====学生管理系统=====");
						System.out.println("1.添加学生信息");
						System.out.println("2.显示学生信息");
						System.out.println("3.删除学生信息");
						System.out.println("4.修改学生信息");
						System.out.println("5.查看学生信息");
						System.out.println("6.排序");
						System.out.println("7.退出");

						Scanner scanner = new Scanner(System.in);
						int anInt = scanner.nextInt();

						switch (anInt) {
								case 1:
										addStudent(arr);
										break;
								case 2:
										findStudent(arr);
										break;
								case 3:
										deleteStudent(arr);
										break;
								case 4:
										updateStudent(arr);
										break;
								case 5:
										getStudent();
										break;
								case 6:
										System.out.println("请选择排序方法:1.按学号排序\\t2.按成绩排序");
										Scanner sc = new Scanner(System.in);
										int num = sc.nextInt();
										switch (num) {
												case 1:
														sortById(arr);
														break;
												case 2:
														sortByScore(arr);
														break;
												default:
														break;
										}
										break;
								case 7:
										System.out.println("谢谢使用");
										System.exit(0);
								default:
										break;
						}
				}
		}

		/**
		 * 判断学生学号是否已被占用
		 * @param stu
		 * @param id
		 * @return
		 */
		public static boolean isUsed(Student[] stu, int id) {

				Student student = new Student();
				boolean flag = false;
				for (int i = 0; i < stu.length; i++) {
						if (id == student.getId()) {
								flag = true;
								break;
						}
				}
				return flag;
		}

		/**
		 * 添加学生信息方法
		 * @param stu
		 */
		private static void addStudent(Student[] stu) {

				Scanner sc = new Scanner(System.in);
				int id;
				while (true) {
						System.out.println("请输入学生学号");
						id = sc.nextInt();

						boolean flag = isUsed(stu, id);
						if (flag) {
								System.out.println("你输入的学号已被占用，请重新输入");
						} else {
								break;
						}
				}

				System.out.println("请输入学生姓名");
				String name = sc.next();
				System.out.println("请输入学生成绩");
				double score = sc.nextDouble();

				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setScore(score);

				stu[id] = student;

				System.out.println("添加学生成功");

		}

		/**
		 * 显示全部学生信息方法
		 * @param stu
		 */
		private static void findStudent(Student[] stu) {

				if (stu.length == 0) {
						System.out.println("没有信息，请先添加信息再查询");
						return;
				}

				System.out.println("学号\t\t姓名\t成绩");

				for (int i = 0; i < stu.length; i++) {
						Student s = new Student();
						System.out.println(s.getId() + "\t\t" + s.getName() + "\t" + s.getScore());
				}

		}

		/**
		 * 删除学生信息方法
		 * @param stu
		 */
		private static void deleteStudent(Student[] stu) {

				Scanner sc = new Scanner(System.in);
				System.out.println("请输入你要删除的学生的学号");
				int id = sc.nextInt();
				for (int i = 0; i < stu.length; i++) {
						if (stu[i] != null) {
								if (stu[i].getId() == id) {
										stu[i] = null;
										System.out.println("删除学生成功");
										return;
								}
						}
						System.out.println("没有这个编号的学生");
				}
		}

		/**
		 * 修改学生方法
		 * @param stu
		 */
		private static void updateStudent(Student[] stu) {

				Scanner sc = new Scanner(System.in);
				int id;

				while (true) {
						System.out.println("请输入要修改的学生学号");
						id = sc.nextInt();

						boolean flag = isUsed(stu, id);
						if (!flag) {
								System.out.println("你输入的学号不存在，请重新输入");
						} else {
								break;
						}
				}

				System.out.println("请输入学生新姓名");
				String name = sc.nextLine();
				System.out.println("请输入学生新成绩");
				double score = sc.nextDouble();

				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setScore(score);

				for (int i = 0; i < stu.length; i++) {
						if (id == student.getId()) {
								stu[id] = student;
								break;
						}
				}

				System.out.println("修改学生信息成功");
		}

		/**
		 * 查看学生信息方法
		 */
		private static void getStudent() {
		}

		/**
		 * 按学号排序
		 * @param stu
		 */
		private static void sortById(Student[] stu) {
		}

		/**
		 * 按成绩排序
		 * @param stu
		 */
		private static void sortByScore(Student[] stu) {
		}

}
