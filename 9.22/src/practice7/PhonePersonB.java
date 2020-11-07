package practice4;

/**
 * @author YangYonggang on 2020/9/22 4:33 下午
 * @Description:do
 */
public class PhonePersonB extends Thread {

		private final CallPhonePerson callPhonePerson;

		public PhonePersonB(String name, CallPhonePerson callPhonePerson) {
				super(name);
				this.callPhonePerson = callPhonePerson;
		}

		@Override
		public void run() {
				while (true) {
						try {
								if (!callPhonePerson.getPerson().isFlag()) {

										synchronized (callPhonePerson.getPerson()) {

												callPhonePerson.getPerson().notify();//唤醒正在休眠的线程
												System.out.println(getName() + "正在拨号...");
												callPhonePerson.getPerson().setFlag(true);
												System.out.println(callPhonePerson.getPerson().getName()
												+ "正在接入" + getName() + "的电话...");
												try {
														Thread.sleep(10000);
												} catch (InterruptedException e) {
														e.printStackTrace();
												}
												System.out.println(callPhonePerson.getPerson().getName()
												+ "与" + getName() + "的电话结束.....");
										}
								} else {
										try {
												sleep(1000); //休息一下再打
										} catch (InterruptedException e) {
												e.printStackTrace();
										}
										System.out.println(callPhonePerson.getPerson().getName() + "正在通话中...B");
								}
						} catch (Exception e) {
								e.printStackTrace();
						}
				}

		}
}
