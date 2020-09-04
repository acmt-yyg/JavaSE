package practice01;

/**
 * @author YangYonggang on 2020/9/4 10:48 上午
 * @Description:9.4作业 1.请思考验证当float类型变量中保存了超出了int所能表示的范围的数字，将这个变量强制转换为int数据类型后，int数据类型变量中保存的值是多少
 * 2.编写示例证明||会出现短路而|是不会短路的
 */
public class Practice {

		public static void main(String[] args) {

				float aFloat = 3.14E29F;
				int anInt = (int) aFloat;
				System.out.println("aFloat数值是：" + aFloat);
				System.out.println("转换成int的数值是：" + anInt);
				// 2147483647 转换成int的所能表示的最大数值

				int num = 0;
				if (true || ++num < 0) {
						System.out.println("||会出现短路");
				}
				System.out.println("num=" + num);

				if (true | ++num < 0) {
						System.out.println("|不会短路");
				}
				System.out.println("num=" + num);
		}

}
