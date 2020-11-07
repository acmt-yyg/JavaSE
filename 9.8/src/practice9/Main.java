package Practice;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author YangYonggang on 2020/9/8 4:35 下午
 * @Description:do
 */
public class Main {

		public static void main(String[] args) {

				byte[] by = {65, 67, 68, 97, 98, 101};
				// 1.转换成字符串输出
				System.out.println(new String(by));
				// 从指定的位置开始到结束转换成字符串输出
				System.out.println(new String(by).substring(2));
				// 2.同样的自定义一个字符数组用字符串的方式输出
				char[] ch = {'A', 'B', 'C'};
				System.out.println(new String(ch).toCharArray());
				// 3."abcdw" "ABCDw" 比较两个字符串是否相等  忽略大小写
				System.out.println("abcdw".equalsIgnoreCase("ABCDw"));
				// 4."我是你的谁,我是你的剑" 判断是否包含 "剑"
				System.out.println("我是你的谁,我是你的剑".contains("剑"));
				// 5.第四题字符串判断是否以"我开头",判断是否以"剑"结尾
				System.out.println("我是你的谁,我是你的剑".startsWith("我"));
				System.out.println("我是你的谁,我是你的剑".endsWith("剑"));
				// 6.String   str=""和 String  str2=null; 判断他们是否为空
				String str = "";
				String str2 = null;
				System.out.println(str.isEmpty());
//				System.out.println(str2.isEmpty());// NullPointerException
				System.out.println("".equals(str2));
				// 7.找到此字符串"我是你的小宝贝"的 "我" 进行输出
				System.out.println("我是你的小宝贝".charAt(0));
				// 8.找出 "我是你的谁,我是你的剑" 里面的 "你" 第一次出现的位置
				System.out.println("我是你的谁,我是你的剑".indexOf("你"));
				// 9.找到上面 8 题的 最后一次出现 "你" 的位置,然后再从 第4个位置开始找  第一次出现的"你"
				System.out.println("我是你的谁,我是你的剑".lastIndexOf("你"));
				System.out.println("我是你的谁,我是你的剑".indexOf("你", 4));
				// 10."我是你的谁,我是你的剑"  从指定位置开始截取长度;从指定位置开始截取到指定位置结束长度的字符串
				System.out.println("我是你的谁,我是你的剑".substring(1).length());
				System.out.println("我是你的谁,我是你的剑".substring(1, 9));
				// 11." 我是你的谁,我是你的剑 " 去除字符串左右空格
				System.out.println(" 我是你的谁,我是你的剑 ".trim());
				// 12. "我是你的谁,我是你的剑"  替代字符串里面的"谁",改为"被子"
				System.out.println("我是你的谁,我是你的剑".replace("谁", "被子"));
				// 13."我是你的谁,我是你的剑"  替换该字符串的所有的 "你" 改为 "哈"
				System.out.println("我是你的谁,我是你的剑".replaceAll("你", "哈"));
				// 14. 比较 "avabc" 和 "avab" 字符串
				System.out.println("avabc".equals("avab"));
				// 15. 将字符数组转换成 字符串输出
				char[] chars = {'A', 'B', 'C', 'D'};
				System.out.println(new String(chars).toCharArray());
				// 16. 将字节数组以指定的编码格式转换成字符串，再转换后的字符串以指定的编码格式转换成字节数组
				byte[] bytes = {97, 98, 99, 100};
				String s = new String(bytes, Charset.forName("Big5"));
				System.out.println(s);
				byte[] bytes1 = s.getBytes(Charset.forName("Big5"));
				System.out.println(Arrays.toString(bytes1));
		}
}
