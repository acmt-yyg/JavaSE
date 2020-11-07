package club.banyuan.video;

import java.io.IOException;
import java.util.Properties;

/**
 * @author YangYonggang on 2020/9/29 4:59 下午
 * @Description:do
 */
public class PropUtil {

		private static Properties properties;

		/**
		 * public void load(InputStream inStream)
		 * 从输入流中读取属性列表（键和元素对）。输入流按 load(Reader) 中所指定的、简单的面向行的格式，
		 * 并假定使用 ISO 8859-1 字符编码；即每个字节都是 Latin1 字符。对于非 Latin1 的字符和某些特殊字符，
		 * 可以使用 Unicode 转义以键和元素的形式来表示它们。
		 *
		 * @param inStream - 输入流
		 */
		static {
				properties = new Properties();
				try {
						// getResourceStream 查找具有给定名称的资源
						properties.load(PropUtil.class.getResourceAsStream("/video.properties"));
				} catch (IOException e) {
						System.out.println("读取配置文件失败");
						System.exit(1); // 一般放在catch中，当捕捉到异常时，非正常退出程序
				}
		}

		/**
		 * public String getProperty(String key)
		 * 用指定的键在此属性列表中搜索属性。如果在此属性列表中未找到该键，
		 * 则接着递归检查默认属性列表及其默认值。如果未找到属性，则此方法返回 null。
		 *
		 * @param key key - 属性键
		 * @return 属性列表中具有指定键值的值
		 */
		public static String getProp(String key) {
				return properties.getProperty(key);
		}
}
