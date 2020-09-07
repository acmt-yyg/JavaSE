package practice02;

/**
 * @author YangYonggang on 2020/9/5 1:54 下午
 * @Description: 4.编写一个方法不使用 * 完成两个数相乘
 * int multiply(int n1, int n2)
 */
public class Multiply {

		public static int multiply(int n1, int n2) {

				int res = 0;
				if (n1 == 0 || n2 == 0) {
						return 0;
				}
				if (n1 > 0) {
						for (int i = 0; i < n1; i++) {
								res += n2;
						}
						return res;
				}
				if (n1 < 0) {

						if (n2 > 0) {
								for (int i = 0; i < n2; i++) {
										res += n1;
								}
								return res;
						}
						if (n2 < 0) {
								int n = Math.abs(n2);
								for (int i = 0; i < n; i++) {
										res += n1;
								}
								return -res;
						}
				}
				return res;
		}

		public static void main(String[] args) {

				System.out.println(multiply(-2, 1));
		}
}
