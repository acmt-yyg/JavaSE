package Practice;

/**
 * @author YangYonggang on 2020/9/8 7:25 下午
 * @Description: 模仿C语言中的顺序表, 创建一个StringList容器类
 * 该类有 增、删、改、查的功能
 * void addStr(String str);
 * void addStr(String str,int  position); //在指定的位置插入字符串
 * String  remove(String  str);           //得到的是移除之后的字符串
 * void update (String  str);             //修改指定的字符串
 * String  getStr(int index);             //获取指定字符串的下标
 * boolean  empty();                      //判断该StringList 容器中是否为空
 */
public class StringList {

		String list = "";

		// 增加字符串方法
		public void addStr(String str) {
				list += str;
		}

		//在指定的位置插入字符串
		public void addStr(String str, int position) {
				for (int i = 0; i < str.length() - 1; i--) {
						if (position == i) {
								str.toCharArray()[position] = str.charAt(i - 1);
						}
				}
		}

		//得到的是移除之后的字符串
		public String remove(String str) {
				return null;
		}

		//修改指定的字符串
		public void update(String str) {

		}

		//获取指定字符串的下标
		public String getStr(int index) {
				return null;
		}

		//判断该StringList 容器中是否为空
		public boolean isEmpty() {
				if (list != null) {
						return false;
				}
				return true;
		}
}
