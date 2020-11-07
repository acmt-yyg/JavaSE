package banyuan;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author YangYonggang on 2020/10/28 8:04 下午
 * @Description:do
 */
public class PropUtil {

		private static final Properties properties;

		static {
				properties = new Properties();
				try (InputStream resourceAsStream = PropUtil.class.getResourceAsStream("/app.properties")) {
						properties.load(resourceAsStream);
				} catch (IOException e) {
						e.printStackTrace();
				}
		}

		public static String getProp(String key) {
				return properties.getProperty(key);
		}
}
