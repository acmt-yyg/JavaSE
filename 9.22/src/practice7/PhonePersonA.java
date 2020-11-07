package practice4;

/**
 * @author YangYonggang on 2020/9/22 4:33 下午
 * @Description:do
 */
public class PhonePersonA extends Thread {

		private final CallPhonePerson callPhonePerson;

		public PhonePersonA(String name, CallPhonePerson callPhonePerson) {
				super(name);
				this.callPhonePerson = callPhonePerson;
				// this.callPhonePerson.getPerson().setFlag(flag);
		}

		@Override
		public void run() {
				while (true) {
						try {
								if (callPhonePerson.getPerson().isFlag()) {
										synchronized (callPhonePerson.getPerson()) {
												callPhonePerson.getPerson().notify();//唤醒正在休眠的线程
												System.out.println(getName() + "正在拨号...");
												callPhonePerson.getPerson().setFlag(false);
												System.out.println(callPhonePerson.getPerson().getName() + "正在接入" + getName() + "的电话...");
												try {
														Thread.sleep(10000);
												} catch (InterruptedException e) {
														e.printStackTrace();
												}
												// callPhonePerson.getPerson().setFlag(false);
												System.out.println(callPhonePerson.getPerson().getName() + "与" + getName() + "的电话结束.....");
										}
								} else {
										//休息一下再打
										try {
												sleep(1000);
										} catch (InterruptedException e) {
												e.printStackTrace();
										}
										System.out.println(callPhonePerson.getPerson().getName() + "正在通话中...A");
								}
						} catch (Exception e) {
								e.printStackTrace();
						}

				}
		}
}
