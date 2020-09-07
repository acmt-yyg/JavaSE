/**
 * 定义类，类是用来描述对象模板的，一个对象中应该包含哪些属性
 */
public class Elephant {

		// field 成员变量、属性、字段
		private int heightInCM = 200;

		/**
		 * 构造方法：没有返回值，方法名和类名一致
		 * @param heightInCM
		 */
		Elephant(int heightInCM) {
				this.heightInCM = heightInCM;
		}

		public Elephant() {
		}

		public int getHeightInCM() {
				return heightInCM;
		}

		public void setHeightInCM(int heightInCM) {
				this.heightInCM = heightInCM;
		}

		public static void main(String[] args) {
				Elephant elephant=new Elephant();
				elephant.heightInCM=-5;
				elephant.setHeightInCM(-5);
		}
}
