package practice01.club.banyuan;

public class Person {

		private String name;
		private int age;
		static int num; // 统计创建 Person 对象的总数
		static int count; // 统计调用了两个参数的构造方法的总数

		static {
				num++;
		}

		public Person(String name, int age) {
				this.name = name;
				this.age = age;
				count++;
		}

		public static int getNum() {
				return num;
		}


		public static int getCount() {
				return count;
		}


		public Person(String name) {
				this.name = name;
		}

		public Person() {
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public int getAge() {
				return age;
		}

		public void setAge(int age) {
				this.age = age;
		}

}
