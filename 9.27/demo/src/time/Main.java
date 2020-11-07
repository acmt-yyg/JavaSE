package time;

/**
 * @author YangYonggang on 2020/9/27 1:58 下午
 * @Description:do
 */
public class Main {

		public static void main(String[] args) {

				PrintTime printTime = new PrintTime();

				QuitProgram quitProgram=new QuitProgram(printTime);
				quitProgram.start();

				Thread printThread =new Thread(printTime);
				printThread.start();
		}
}
