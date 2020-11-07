package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author YangYonggang on 2020/10/9 9:35 上午
 * @Description:do
 */
public class UdpServer {

		public static void main(String[] args) throws IOException {
				while (true) {
						DatagramSocket socket = new DatagramSocket(10000);
						byte[] buf = new byte[1024];
						DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

						socket.receive(datagramPacket);

						byte[] data = datagramPacket.getData();
						int length = datagramPacket.getLength();

						System.out.println("接收到来自：" + datagramPacket.getAddress().getHostAddress() + "的消息:" + new String(data, 0, length));

						DatagramSocket socket1 = new DatagramSocket();

						socket1.send(new DatagramPacket(data, length, InetAddress.getByName("192.168.8.94"), 9999));

						socket.close();
						socket1.close();
				}

		}
}
