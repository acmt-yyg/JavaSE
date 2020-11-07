package practice2;

/**
 * @author YangYonggang on 2020/9/8 6:24 下午
 * @Description:
 * 2.定义一个StringBuffer类对象, 对外提供方法接收字符串或字符，通过一个方法将之前接收到的字符拼接到一起返回
 */
public class StringBuffer {

		private String stringBuffer = "";

		// 接受字符串
		public void append(String str) {
				stringBuffer += str;
		}

		// 接受字符
		public void append(char str) {
				stringBuffer += str;
		}

		// 将之前接受到的字符拼接到一起返回
		public String toString() {
				return stringBuffer;
		}

		// 清除之前的输入内容
		void clear() {
				stringBuffer = "";
		}

		// 将之前的输入内容反转
		public String reverse() {
				return stringReverse(stringBuffer);
		}

		// 字符串反转方法
		public String stringReverse(String str) {
				char[] chars = str.toCharArray();
				char[] reverseChar = new char[chars.length];
				for (int i = 0; i < chars.length; i++) {
						reverseChar[chars.length - i - 1] = chars[i];
				}
				return new String(reverseChar);
		}

		// 将指定位置的字符反转
		public String reverse(int from, int to) {
				String begin = stringBuffer.substring(0, from);
				String end = stringBuffer.substring(to);
				return begin + stringReverse(stringBuffer.substring(from, to)) + end;
		}
}
