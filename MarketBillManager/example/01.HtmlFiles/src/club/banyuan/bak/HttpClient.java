package club.banyuan.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author YangYonggang on 2020/10/12 9:28 上午
 * @Description: 模拟浏览器请求数据
 */
public class HttpClient {

		public static void main(String[] args) {

				try (Socket socket = new Socket("127.0.0.1", 9000)) {

						DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
						outputStream.writeBytes("GET /login.html HTTP/1.1\n");
						outputStream.writeBytes("Host: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "\n");
						outputStream.writeBytes("\n");
						outputStream.flush();

						BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String line = reader.readLine();
						int contentLength = 0;
						while (line != null && line.length() != 0) {
								if (line.startsWith("Content-Length: ")) {
										contentLength = Integer.parseInt(line.replace("Content-Length: ", ""));
								}
								line = reader.readLine();
						}

						if (contentLength > 0) {
								char[] payload = new char[contentLength];
								int read = reader.read(payload);
								String data = new String(payload, 0, read);
								System.out.println(read);
								System.out.println(data.getBytes().length);
								System.out.println(contentLength);
								System.out.println(data);
						}


				} catch (UnknownHostException e) {
						e.printStackTrace();
				} catch (IOException e) {
						e.printStackTrace();
				}
		}
}
