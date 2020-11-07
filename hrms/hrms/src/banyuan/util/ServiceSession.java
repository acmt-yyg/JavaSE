package banyuan;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author YangYonggang on 2020/10/28 5:03 下午
 * @Description:do
 */
public class ServiceSession extends HashMap<String, Object> {
		/**
		 * 在创建对象时生成唯一的字符串
		 * public final class UUID：表示通用唯一标识符 (UUID) 的类。
		 * public static UUID randomUUID()：获取类型 4（伪随机生成的）UUID 的静态工厂。 使用加密的强伪随机数生成器生成该 UUID。返回：随机生成的 UUID。
		 */
		private final String sessionId = UUID.randomUUID().toString();

		private boolean isValid = true;

		public String getSessionId() {
				return sessionId;
		}

		public boolean isValid() {
				return isValid;
		}

		public void invalidate() {
				isValid = false;
		}
}
