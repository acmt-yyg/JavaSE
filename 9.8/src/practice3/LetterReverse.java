package Practice;

/**
 * @author YangYonggang on 2020/9/8 6:59 下午
 * @Description:3.编写一个程序，将下面的一段文本中的各个单词的字母顺序翻转， "To be or not to be"，将变成"oT eb ro ton ot eb."
 */
public class LetterReverse {

		// 字符串反转方法
		public String stringReverse(String str) {
				char[] chars = str.toCharArray();
				char[] reverseChar = new char[chars.length];
				for (int i = 0; i < chars.length; i++) {
						reverseChar[chars.length - i - 1] = chars[i];
				}
				return new String(reverseChar);
		}

		public static void main(String[] args) {

				StringBuffer sb = new StringBuffer();

				String str = "To be or not to be";
				String[] strings = str.split(" ");
				for (int i = 0; i < strings.length; i++) {
						String s = strings[i];
						if (i != strings.length - 1) {
								System.out.printf(sb.stringReverse(s) + " ");
						} else {
								System.out.printf(sb.stringReverse(s) + ".");
						}
				}
		}
}
