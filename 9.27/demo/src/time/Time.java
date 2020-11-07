package time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author YangYonggang on 2020/9/27 1:38 下午
 * @Description:do
 */
public class Time {

		public static void main(String[] args) {

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

				Scanner scanner=new Scanner(System.in);
				while (true) {
						try {
								Thread.sleep(1000);
						} catch (InterruptedException e) {
								e.printStackTrace();
						}
						System.out.println(simpleDateFormat.format(new Date()));
						String s = scanner.nextLine();
						if("quit".equalsIgnoreCase(s)){
								break;
						}
				}
				System.out.println("系统退出");
		}
}
