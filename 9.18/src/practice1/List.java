package practice1;

import java.util.*;

/**
 * @author YangYonggang on 2020/9/18 4:34 下午
 * @Description:do
 */
public class List {
		public static void main(String[] args) {

				ArrayList<String> list = new ArrayList<String>();

				list.add("apple");
				list.add("grape");
				list.add("banana");
				list.add("pear");

				System.out.println("最大的元素是：" + Collections.max(list));
				System.out.println("最小的元素是：" + Collections.min(list));

				Collections.sort(list);
				for (String s : list) {
						System.out.print(s + " ");
				}
		}

}
