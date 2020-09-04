import java.util.Arrays;

/**
 * /**
 * 作业2：定义一个Practice.java文件，将以下代码写到文件的main方法中
 * 1. 如果要保存7天时间的毫秒值（7x24x60x60x1000=604800000），需要使用什么数据类型，请选用合理的变量名称，将定义和初始化过程记录到答案中。
 * 2. 如果要保存30天时间的毫秒值(30x24x60x60x1000=2592000000)，需要使用什么数据类型，请选用合理的变量名称，将定义和初始化过程记录到答案中
 * 3. 如何验证小数字面量默认值是double数据类型的，请将代码说明记录到答案中
 * 4. 如何证明数组的length是final的，如何证明数组length是int类型
 * 5. 尝试定义并初始化一个二维数组，第一行有3个元素{"你","我","他"}，第二行有5个元素{"金","木","水","火","土"}，第三行有2个元素{"天","地"}，请选用合适的数据类型定义，注意第二维度数组的长度是不同的
 *
 * @author YangYonggang on 2020/9/3
 */
public class Practice {

		public static void main(String[] args) {

				int sevenTime = 7 * 24 * 60 * 60 * 1000;
				System.out.println(sevenTime);

				long thirtyDayTimeMillisecondValue = 30 * 24 * 60 * 60 * 1000L;
				System.out.println(thirtyDayTimeMillisecondValue);

				System.out.println(3.14E39);
//				System.out.println(3.14E39F)
				System.out.println(3.14E39D);

				int[] array = new int[5];
//				arr.length=3; // 重新赋值时编译报错，证明数组的length是final的
//				int[] arr1 = new int[0xFFFFFFFFF]; // 超过int类型的编译报错，证明数组length是int类型

				String[][] arr = new String[3][];
				arr[0] = new String[]{"你", "我", "他"};
				arr[1] = new String[]{"金", "木", "水", "火", "土"};
				arr[2] = new String[]{"天", "地"};
				for (int i = 0; i < arr.length; i++) {
						System.out.println(Arrays.toString(arr[i]));
				}
		}
}
