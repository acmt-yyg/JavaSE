package banyuan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YangYonggang on 2020/10/28 5:11 下午
 * @Description:do
 */
public class SessionUtil {

		/**
		 * 用Map存储sessionId。
		 * session对应一个ServerSession，每个ServerSession对应一个浏览器，将sessionId写入到浏览器的cookie中
		 */
		private static final Map<String, ServiceSession> serverSessionMap = new HashMap<>();

		/**
		 * 通过id获取session
		 *
		 * @param sessionId
		 * @return
		 */
		public static ServiceSession getSessionById(String sessionId) {
				return serverSessionMap.get(sessionId);
		}

		/**
		 * 将sessionId存储到浏览器的cookie中
		 *
		 * @param sessionId
		 * @param serverSession
		 */
		public static void put(String sessionId, ServiceSession serverSession) {
				serverSessionMap.put(sessionId, serverSession);
		}

		/**
		 * 将sessionId删除
		 *
		 * @param sessionId
		 */
		public static void remove(String sessionId) {
				serverSessionMap.remove(sessionId);
		}
}
