package club.banyuan;

/**
 * @author YangYonggang on 2020/9/11 4:48 下午
 * @Description:do
 */
public class Commission extends Hourly {

		// 该雇员的总销售额
		private double theEmployeeSTotalSales;
		// 该雇员的佣金率
		private double theEmployeeSCommissionRate;

		public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate) {
				super(eName, eAddress, ePhone, socSecNumber, rate);
		}

		/**
		 * 方法：它将参数添加到表示总销售额的实例变量中。
		 *
		 * @param totalSales 总销售额
		 */
		public void addSales(double totalSales) {


		}

		/**
		 * @return
		 */
		public double pay() {
				return 0.0;
		}
}
