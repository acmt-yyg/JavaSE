package banyuan;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;


/**
 * @author YangYonggang on 2020/10/28 1:45 下午
 * @Description: 服务器端：程序入口
 */
public class HttpService {

		private static final AdminServer adminService = new AdminServer();

		public static AdminServer getAdminService() {
				return adminService;
		}

		public static void main(String[] args) {

				try (ServerSocket serverSocket = new ServerSocket(9000)) {

						System.out.println("创建服务器");

						while (true) {
								OutputStream outputStream = null;
								Socket socket = null;
								Request request = null;
								try {
										socket = serverSocket.accept();
										System.out.println("客户端接入");
										request = Request.parse(socket.getInputStream());
										outputStream = socket.getOutputStream();
										String url = request.getUrl();
										if (url.startsWith("/admin/") || url.startsWith("/empl/") || url.startsWith("/position/") || url.startsWith("/dept/")) {
												validateAdminAuth(request);
												Map map = disPathRequest(request);
												sendJsonResponse(RespStatus.OK, outputStream, map, request);
										} else {
												sendStaticFile(outputStream, request);
										}
								} catch (BadReqException e) {
										e.printStackTrace();
//										sendJsonResponse(RespStatus.BAD_REQUEST, outputStream,e.getMessage(), request);
								} catch (RedirectException e) {
										e.printStackTrace();
//										sendRedirectResponse(RespStatus.REDIRECT, outputStream, e.getMessage(), request);
								} catch (Exception e) {
										e.printStackTrace();
//										sendJsonResponse(RespStatus.INTERNAL_SERVER_ERROR, outputStream, e.getMessage(), request);
								} finally {
										if (socket != null) {
												socket.close();
										}
								}
						}
				} catch (IOException e) {
						e.printStackTrace();
				}
		}


		/**
		 * 服务器发送重定向的响应
		 *
		 * @param status
		 * @param outputStream
		 * @param message
		 * @param request
		 */
		private static void sendRedirectResponse(RespStatus status, OutputStream outputStream, String message, Request request) throws IOException {
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
				dataOutputStream.writeBytes(status.getMsg());
				dataOutputStream.writeBytes("Location: http://" + request.getHost() + message + "\n");
				dataOutputStream.writeBytes("\n");
				dataOutputStream.flush();
		}


		/**
		 * 服务器发送静态文件到浏览器
		 *
		 * @param outputStream
		 * @param request
		 */
		private static void sendStaticFile(OutputStream outputStream, Request request) throws IOException {
				String url = request.getUrl();
				File file = new File(PropUtil.getProp("page.root"), url);
				if (!file.isFile()) {
						file = new File(PropUtil.getProp("page.root"), "/404.html");
				}
				try (FileInputStream fileInputStream = new FileInputStream(file)) {
						DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
						dataOutputStream.writeBytes("HTTP/1.1 200 OK\n");
						dataOutputStream.writeBytes("Content-Length: " + fileInputStream.available() + "\n");

						if (url.endsWith(".html")) {
								dataOutputStream.writeBytes("Content-Type: text/html; charset=utf-8;\n");
						} else if (url.endsWith(".css")) {
								dataOutputStream.writeBytes("Content-Type: text/css; charset=utf-8;\n");
						}

						writeCookie(dataOutputStream, request);
						dataOutputStream.writeBytes("\n");
						dataOutputStream.write(fileInputStream.readAllBytes());
						dataOutputStream.flush();
				}
		}

		/**
		 * 验证管理员身份：因为有些接口，必须保证用户已经登录才能正常操作
		 *
		 * @param request
		 */
		private static void validateAdminAuth(Request request) {
				String url = request.getUrl();
				if (!url.endsWith("/login.html")) {
						Object o = request.getSession().get(Constant.USER_INFO);
						if (o == null) {
								throw new BadReqException("用户未登录");
						}
				}
		}


		/**
		 * 服务器发送的响应：将要返回的信息进行封装，封装后转换为json字符串的格式为{"data":xxx}
		 *
		 * @param status
		 * @param outputStream
		 * @param map
		 * @param request
		 * @throws IOException
		 */
		private static void sendJsonResponse(RespStatus status, OutputStream outputStream, Map<String,Object> map, Request request) throws IOException {

//				Map<String, Object> rlt = new HashMap<>();
//				rlt.put("data", msg);
				byte[] bytes = JSONObject.toJSONString(map).getBytes();
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
				dataOutputStream.writeBytes(status.getMsg());
				dataOutputStream.writeBytes("Content-Length: " + bytes.length + "\n");
				dataOutputStream.writeBytes("Content-TYpe: application/json; charset=utf-8\n");
				writeCookie(dataOutputStream, request);
				dataOutputStream.writeBytes("\n");
				dataOutputStream.write(bytes);

				outputStream.flush();
		}


		/**
		 * 服务器将分配的sessionId写入到浏览器的Cookie文本中，并设置有效时间
		 *
		 * @param outputStream
		 * @param request
		 */
		private static void writeCookie(DataOutputStream outputStream, Request request) throws IOException {
				ServiceSession session = request.getSession();
				String sessionId = session.getSessionId();
				if (session.isValid()) {
						outputStream.writeBytes("Set-Cookie: " + Constant.COOKIE_SESSION_ID + "=" + sessionId + ";path=/\n");
				} else {
						outputStream.writeBytes("Set-Cookie: " + Constant.COOKIE_SESSION_ID + "=" + sessionId + "; path=/; Max-Age=0\n");
				}
		}


		/**
		 * 根据url不同，使用不同的方法进行处理
		 *
		 * @param request
		 * @return
		 */
		private static Map disPathRequest(Request request) {

				String url = request.getUrl();
				Map<String, Object> map = new HashMap<>();
				switch (url) {

						// 登录界面
						case "/admin/login": {
								Admin admin = request.parseJsonObject(Admin.class);
								Admin loginAdmin = adminService.login(admin);
								if (loginAdmin == null) {
										map.put("code", 1);
										map.put("message", "用户名或密码错误");
								} else {
										map.put("code", 0);
										map.put("message", "操作成功");
								}
						}
						break;


						// 用户界面
//						case "/admin/list": {
//								Admin admin = request.parseJsonObject(Admin.class);
//								return adminService.getAdminList(admin);
//						}
//						case "/admin/add": {
//								Admin admin = request.parseJsonObject(Admin.class);
//								adminService.add(admin);
//						}
//						break;
//						case "/admin/update": {
//								Admin admin = request.parseJsonObject(Admin.class);
//								adminService.updateUser(admin);
//						}
//						break;
//						case "/admin/delete": {
//								Admin admin = request.parseJsonObject(Admin.class);
//								adminService.delete(admin.getId());
//						}
//						break;
//						case "/admin/info": {
//
//						}
//						break;
//						case "/admin/logout": {
//
//						}
//						break;
				}

				return map;
		}
}
