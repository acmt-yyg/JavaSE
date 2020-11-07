package practice1;

/**
 * @author YangYonggang on 2020/9/14 7:37 下午
 * @Description:do
 */
interface Anonymous {
		public int getValue();
}

public class Outer {
		private int data = 15;

		public static void main(String[] args) {
				Anonymous inner = new Anonymous() {
						int data = 5;

						public int getValue() {
								return data;
						}

						public int getData() {
								return data;
						}
				};
				Outer outer = new Outer();
				System.out.println(inner.getValue() + inner.getData() + outer.data);
		}
}
