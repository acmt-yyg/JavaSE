package practice2;

import java.util.*;

/**
 * @author YangYonggang on 2020/9/18 5:00 下午
 * @Description:do
 */
public class Demo {

		public static void main(String[] args) {

				// 定义一个List集合
				ArrayList<Integer> list = new ArrayList<Integer>();

				// 生成10个1至100之间的随机整数(不能重复)
				for (int i = 0; i < 10; i++) {
						int num = (int) (Math.random() * 100) + 1;
						for (int j = 0; j < i; j++) {
								if (num == list.get(j)) {
										j = -1; // 如果重复，需要将 j 重置为0
								}
						}
						// 将生成的数存入集合中
						list.add(num);
				}
				// 打印生成的集合
				System.out.println(list);

				// 用Collections工具类进行排序
				Collections.sort(list);
				// 打印排序后的集合
				System.out.println(list);

				// 利用迭代器遍历集合元素并输出
				Iterator<Integer> it = list.iterator();
				while (it.hasNext()) {
						System.out.print(it.next() + " ");
				}
		}
}
