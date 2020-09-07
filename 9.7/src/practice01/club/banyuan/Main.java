package practice01.club.banyuan;

public class Main {

		public static void main(String[] args) {
				Person person = new Person();
				Person zhangsan = new Person("张三", 18);
				Person lisi = new Person("李四");
				Person wangwu = new Person("王五");
				Person zhaoliu = new Person("赵六", 20);

				System.out.println("一共创建了" + Person.getNum() + "个对象");
				System.out.println("两个参数的构造方法被调用了" + Person.getCount() + "次");
		}
}
