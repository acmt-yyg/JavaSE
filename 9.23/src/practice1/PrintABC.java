package practice1;

/**
 * @author YangYonggang on 2020/9/23 10:04 上午
 * @Description:do
 */
public class PrintLetter {

		private int index = 0;

		public synchronized void print(int n) {

				try {
						while (index != n) {
								wait();
						}
						if (index == 0) {
								System.out.println("A");
						} else if (index == 1) {
								System.out.println("B");
						} else if (index == 2) {
								System.out.println("C");
						}
						index = (n + 1) % 3;
						notifyAll();
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
		}

		public static void main(String[] args) {

				new AThread().start();
				new BThread().start();
				new CThread().start();
		}
}

class AThread extends Thread {

		private PrintLetter printLetter;

		@Override
		public void run() {
				for (int i = 0; i < 10; i++) {
						printLetter.print(0);
				}
		}
}

class BThread extends Thread {

		private PrintLetter printLetter;

		@Override
		public void run() {
				for (int i = 0; i < 10; i++) {
						printLetter.print(1);
				}
		}
}

class CThread extends Thread {

		private PrintLetter printLetter;

		@Override
		public void run() {
				for (int i = 0; i < 10; i++) {
						printLetter.print(2);
				}
		}
}