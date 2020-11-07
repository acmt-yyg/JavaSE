package time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YangYonggang on 2020/9/27 1:50 下午
 * @Description:do
 */
public class PrintTime implements Runnable {

		public static boolean isRunning = true;

		@Override
		public void run() {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
				while (isRunning) {
						try {
								Thread.sleep(1000);
						} catch (InterruptedException e) {
								e.printStackTrace();
						}
						System.out.println(simpleDateFormat.format(new Date()));
				}
				System.out.println("计时器线程退出");
		}
}
