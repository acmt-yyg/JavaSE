package studentlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 集合实现————学生管理类
 * 1.添加学生信息\n
 * 2.显示学生信息\n    显示所有学生信息
 * 3.删除学生信息\n   根据学生id删除学生信息
 * 4.修改学生信息\n   根据学生id修改学生信息
 * 5.查看学生信息\n   查看的条件自定义
 * 6.排序\n  （请选择排序方法:1.按学号排序\t2.按成绩排序）
 * 7.退出
 *
 * @author YangYonggang on 2020/9/3
 */
public class StudentManager {

		public static void main(String[] args) {

				ArrayList<Student> array = new ArrayList<>();

				// 用循环完成再次回到主界面
				while (true) {

						//1.用输出语句完成主界面的编写
						System.out.println("=====学生管理系统=====");
						System.out.println("1.添加学生信息");
						System.out.println("2.显示学生信息");
						System.out.println("3.删除学生信息");
						System.out.println("4.修改学生信息");
						System.out.println("5.查看学生信息");
						System.out.println("6.排序");
						System.out.println("7.退出");

						// 2.用scanner实现键盘录入数据
						Scanner sc = new Scanner(System.in);
						String line = sc.nextLine();

						// 3.用switch语句完成操作的选择
						switch (line) {
								case "1":
										addStudent(array);
										break;
								case "2":
										findAllStudent(array);
										break;
								case "3":
										deleteStudent(array);
										break;
								case "4":
										updateStudent(array);
										break;
								case "5":
										getStudent(array);
										break;
								case "6":
										System.out.println("请选择排序方法:1.按学号排序\\t2.按成绩排序");
										Scanner scanner = new Scanner(System.in);
										int num = scanner.nextInt();
										switch (num) {
												case 1:
														sortById();
														break;
												case 2:
//														sortByScore(array);
														break;
												default:
														break;
										}
										break;
								case "7":
										System.out.println("谢谢使用");
										System.exit(0);
								default:
										break;
						}
				}
		}

		private static void sortByScore(List<Student> array, Double score) {

				Student temp = new Student();
				for (int i = 0; i < array.size() - 1; i++) {
						for (int j = i + 1; j < array.size(); j++) {
								if (array.get(i) != null && array.get(j) != null) {
										temp.getScore().compareTo(score);
								}
						}
				}
		}

		private static void sortById() {

		}

		private static void getStudent(List<Student> array) {
				// 判断集合中是否有数据，如果没有显示提示信息
				if (array.size() == 0) {
						System.out.println("无信息，请先添加信息后再查询");
						return;
				}

				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();

				while (true) {
						System.out.println("请输入学生学号");
						id = sc.nextInt();

						boolean flag = isUsed(array, id);
						if (!flag) {
								System.out.println("你输入的学号不存在，请重新输入");
						} else {
								break;// 退出循环的作用
						}
				}

				System.out.println("学号\t姓名\t成绩");
				Student s = array.get(id);
				System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getScore());
		}

		// 定义一个方法，判断学号是否被使用
		private static boolean isUsed(List<Student> array, int id) {
				// 如果与集合中的某一学生的学号相同，返回true；如果不同，返回false
				boolean flag = false;

				for (int i = 0; i < array.size(); i++) {
						Student s = array.get(i);
						if (s.getId() == id) {
								flag = true;
								break;
						}
				}
				return flag;
		}

		// 定义一个方法，用于添加学生信息
		private static void addStudent(List<Student> array) {

				// 键盘录入学生对象所需要的数据，显示提示信息，提示要输入何种信息
				Scanner sc = new Scanner(System.in);
				// 为了让 id 在while外面被访问到，将 id 定义在循环外面
				int id;

				// 为了让程序能够回到这里，使用循环实现
				while (true) {
						System.out.println("请输入学生学号");
						id = sc.nextInt();

						boolean flag = isUsed(array, id);
						if (flag) {
								System.out.println("你输入的学号已被使用，请重新输入");
						} else {
								break;// 退出循环的作用
						}
				}
				System.out.println("请输入学生姓名");
				String name = sc.next();
				System.out.println("请输入学生成绩");
				int score = sc.nextInt();

				// 创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
				Student student = new Student();
				student.setId(id);
				student.setName(name);

				// 将学生对象添加到集合中
				array.add(student);

				// 给出添加成功提示
				System.out.println("添加学生成功");
		}

		// 定义一个方法，用于删除学生信息
		private static void deleteStudent(List<Student> array) {
				// 键盘录入要删除的学生的学号，显示提示信息
				Scanner sc = new Scanner(System.in);
				System.out.println("请输入你要删除的学生的学号");
				int id = sc.nextInt();

				// 在删除学生之前，对学号是否存在进行判断
				// 如果不存在，请显示提示信息
				// 如果存在，执行删除操作
				int index = -1;
				for (int i = 0; i < array.size(); i++) {
						Student s = array.get(i);
						if (s.getId() == id) {
								index = i;
								break;
						}
				}

				if (index == -1) {
						System.out.println("该信息不存在，请重新输入");
				} else {
						array.remove(index);
				}

				// 给出删除成功提示
				System.out.println("删除学生成功");
		}

		// 定义一个方法，用于修改学生信息
		private static void updateStudent(ArrayList<Student> array) {
				// 键盘录入要修改的学生的学号，显示提示信息
				Scanner sc = new Scanner(System.in);

				// 为了让 id 在while外面被访问到，将 id 定义在循环外面
				int id;

				// 为了让程序能够回到这里，使用循环实现
				while (true) {
						System.out.println("请输入你要修改的学生的学号");
						id = sc.nextInt();

						boolean flag = isUsed(array, id);
						if (!flag) {
								System.out.println("你输入的学号不存在，请重新输入");
						} else {
								break;// 退出循环的作用
						}
				}

				// 从键盘录入要修改的学生信息
				System.out.println("请输入学生新姓名");
				String name = sc.next();
				System.out.println("请输入学生新成绩");
				Double score = sc.nextDouble();

				// 创建学生对象
				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setScore(score);

				// 遍历集合，修改对应学生对象的信息
				for (int i = 0; i < array.size(); i++) {
						Student s = array.get(i);
						if (s.getId() == id) {
								array.set(i, student);
								break;
						}
				}

				// 给出修改成功提示
				System.out.println("修改学生信息成功");
		}

		// 定义一个方法，用于显示学生信息
		private static void findAllStudent(List<Student> array) {
				// 判断集合中是否有数据，如果没有显示提示信息
				if (array.size() == 0) {
						System.out.println("无信息，请先添加信息后再查询");
						return;
				}

				// 显示表头信息
				// \t 键其实就是tab键的位置
				System.out.println("学号\t姓名\t成绩");

				// 将集合中数据取出按照对应格式显示学生信息
				for (int i = 0; i < array.size(); i++) {
						Student s = array.get(i);
						System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getScore());
				}
		}

}
