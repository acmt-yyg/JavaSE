package club.banyuan;

import java.io.IOException;
import java.net.*;

/**
 * @author YangYonggang on 2020/10/9 9:15 上午
 * @Description:do
 */
public class UdpClient {

		public static void main(String[] args) {

				try (DatagramSocket socket = new DatagramSocket()) {
						String msg = "☞🀐♘♠️♣️♥️♦️💻☎️📱🛩🚀🛰🏆🦍";
						DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("127.0.0.1"), 10000);
						socket.send(packet);
				} catch (IOException e) {
						e.printStackTrace();
				}
				// 判断有多少个端口号被占用
//				for (int i = 0; i < 65536; i++) {
//						try {
//								DatagramSocket socket = new DatagramSocket(i);
//								socket.close();
//						} catch (SocketException e) {
//								System.out.println("udp端口号：" + i + "被占用");
//						}
//
//				}
		}
}
