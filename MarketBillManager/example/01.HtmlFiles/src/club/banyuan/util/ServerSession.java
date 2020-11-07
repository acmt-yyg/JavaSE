package club.banyuan.util;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author YangYonggang on 2020/10/13 7:15 下午
 * @Description: 服务器会话类
 * session对象是一个Map，可以存放key value的对应关系
 * session还包含一个唯一id
 */
public class ServerSession extends HashMap<String, Object> {

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
