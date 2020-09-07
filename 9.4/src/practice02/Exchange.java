package practice02;

/**
 * @author YangYonggang on 2020/9/5 3:03 下午
 * @Description:6.有1.5元钱兑换1分，2分，5分硬币100枚，每种面值至少一个，请输出所有的兑换方案，并统计方案的总数
 */
public class Exchange {

		public static void main(String[] args) {

				int count = 0;// 累加方案数
				for (int one = 1; one < 150; one++) {
						for (int two = 1; two < 150 / 2; two++) {
								for (int five = 1; five < 150 / 5; five++) {
										if (one + two + five == 100 && one + two * 2 + five * 5 == 150) {
												count++;
												System.out.printf("1分%d枚,2分%d枚,5分%d枚\n", one, two, five);
												break;
										}
								}
						}
				}
				System.out.printf("总共有%d种方案",count);
		}
}
