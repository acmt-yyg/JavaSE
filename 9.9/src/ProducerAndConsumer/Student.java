package practice2;

/**
 * @author YangYonggang on 2020/9/10 4:45 下午
 * @Description:do
 */
public class Student {

		private String name;

		public final String getName() {
				return name;
		}

		public final void setName(String name) {
				this.name = name;
		}

		public Student(String name) {
				this.name = name;
		}

		public void study() {
				System.out.println(this.name + "在学习");
		}
}
