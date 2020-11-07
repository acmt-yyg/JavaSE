package practice2;

/**
 * @author YangYonggang on 2020/9/23 11:07 上午
 * @Description:do
 */
public class PersonA extends Thread {

		Bank bank;

		String getMoneyType;

		public PersonA(Bank bank, String getMoneyType) {
				this.getMoneyType = getMoneyType;
				this.bank = bank;
		}

		public void run() {
				while (Bank.money > 0) {
						try {
								bank.outMoney(200, getMoneyType);
						} catch (Exception e1) {
								e1.printStackTrace();
						}
				}
		}
}
