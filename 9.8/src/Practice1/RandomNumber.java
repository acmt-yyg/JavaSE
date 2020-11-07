package Practice;

import java.util.Random;

/**
 * @author YangYonggang on 2020/9/8 6:13 下午
 * @Description: 1.设计一个方法，可以实现获取任意范围内的随机数。包括负数，例如输入randomInt(-10,5)
 */
public class RandomNumber {

		public static int RandomInt(int from, int to) {
				return (int) (Math.random() * (to - from + 1) + from);
		}

		public static void main(String[] args) {
				for (int i = 0; i < 50; i++) {
						System.out.println(RandomInt(-10, 5));
				}
		}
}
