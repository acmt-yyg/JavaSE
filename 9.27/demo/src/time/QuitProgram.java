package time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author YangYonggang on 2020/9/27 1:52 下午
 * @Description:do
 */
public class QuitProgram extends Thread {

		private PrintTime printTime;

		public QuitProgram(PrintTime printTime) {
				this.printTime = printTime;
		}

		@Override
		public void run() {
				Scanner scanner = new Scanner(System.in);
				while (true) {
						String s = scanner.nextLine();
						if ("q".equalsIgnoreCase(s)) {
								PrintTime.isRunning = false;
								break;
						}
				}
				System.out.println("接收输入线程退出");
		}
}
