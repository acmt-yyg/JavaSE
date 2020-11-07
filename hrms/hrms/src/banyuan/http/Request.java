package banyuan;

import cn.hutool.json.JSON;
import netscape.javascript.JSObject;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YangYonggang on 2020/10/28 12:04 上午
 * @Description:do
 */
public class Request {

		private String url;
		private String host;
		private int contentLength;
		private String data;
		private Map<String, String> cookies = new HashMap<>();
		private ServiceSession session;

		public void setUrl(String url) {
				this.url = url;
		}

		public String getHost() {
				return host;
		}

		public void setHost(String host) {
				this.host = host;
		}

		public int getContentLength() {
				return contentLength;
		}

		public void setContentLength(int contentLength) {
				this.contentLength = contentLength;
		}

		public String getData() {
				return data;
		}

		public void setData(String data) {
				this.data = data;
		}

		public Map<String, String> getCookies() {
				return cookies;
		}

		public void setCookies(Map<String, String> cookies) {
				this.cookies = cookies;
		}

		public static Request parse(BufferedReader reader) {

				return null;
		}

		public String getUrl() {
				return url;
		}


		public ServiceSession getSession() {
				return session;
		}


		public void setSession(ServiceSession session) {
				this.session = session;
		}

		/**
		 * 解析JSON对象，返回字符串
		 *
		 * @param cls
		 * @param <T>
		 * @return
		 */
		public <T> T parseJsonObject(Class<T> cls) {
				return JSONObject.parseObject(data, cls);
		}

		/**
		 * 解析浏览器发送的信息：将浏览器发送的inpuStream中的数据转换为一个Request对象
		 *
		 * @param inputStream
		 * @return
		 */
		public static Request parse(InputStream inputStream) {

				String url = null;
				String host = null;

				try {
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
						Request request = new Request();
						String line = bufferedReader.readLine();
						url = line.split(" ")[1];
						host = null;
						int contentLength = 0;
						while (line != null && line.length() != 0) {
								if (line.startsWith("Host: ")) {
										host = line.replace("Host: ", "");
								}
								if (line.startsWith("Content=Length: ")) {
										contentLength = Integer.parseInt(line.replace("Content-Length: ", ""));
								}
								if (line.startsWith("Cookie: ")) {
										request.setCookies(parseCookie(line));
								}
								System.out.println(line);
								line = bufferedReader.readLine();
						}

						if (contentLength > 0) {
								char[] payload = new char[contentLength];
								int read = bufferedReader.read(payload);
								String data = new String(payload, 0, read);
								System.out.println("data:" + data);
								request.setData(data);
						}

						System.out.println("url:" + url);
						System.out.println("host:" + host);
						System.out.println("contentLength:" + contentLength);
						System.out.println("读取头部文件结束");

						request.setUrl(url);
						request.setHost(host);
						request.setContentLength(contentLength);

						processSession(request);

						return request;
				} catch (IOException e) {
						e.printStackTrace();
						return null;
				}
		}


		/**
		 * 解析Cookie：解析后存储到Map中
		 *
		 * @param line
		 * @return
		 */
		private static Map<String, String> parseCookie(String line) {
				HashMap<String, String> rlt = new HashMap<>();
				String cookie = line.replace("Cookie:", "");

				String[] split = cookie.split(";");
				for (String keyValue : split) {
						String[] keyValuePair = keyValue.trim().split("=");
						if (keyValuePair.length == 1) {
								rlt.put(keyValuePair[0], "");
						} else if (keyValuePair.length == 2) {
								rlt.put(keyValuePair[0], keyValuePair[1]);
						}
				}
				return rlt;
		}

		/**
		 * 处理请求的session
		 *
		 * @param request
		 */
		private static void processSession(Request request) {
				String sessionId = request.getCookies().get(Constant.COOKIE_SESSION_ID);
				if (sessionId == null) {
						ServiceSession session = new ServiceSession();
						request.setSession(session);
						SessionUtil.put(session.getSessionId(), session);
				} else {
						ServiceSession serviceSession = SessionUtil.getSessionById(sessionId);
						if (serviceSession == null) {
								ServiceSession session = new ServiceSession();
								request.setSession(session);
								SessionUtil.put(session.getSessionId(), session);
						} else {
								request.setSession(serviceSession);
						}
				}
		}
}
