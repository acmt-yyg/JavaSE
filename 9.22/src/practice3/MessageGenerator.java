package Demo2;

import java.util.Random;

/**
 * @author YangYonggang on 2020/9/22 1:49 下午
 * @Description:do
 */

/**
 * 生成消息
 */
public class MessageGenerator extends Thread {

		private CellularPhone phone;

		public MessageGenerator(String name, CellularPhone aPhone) {
				super(name);
				phone = aPhone;
		}

		public void run() {
				int counter = 0;
				Random randomGenerator = new Random();
				while (counter++ < 20) {
						try {
								phone.addMessage(getName() + " " + counter);
								sleep(200);
						} catch (InterruptedException ie) {
								System.err.println("消息生成器中断");
						}
				}
		}


}
