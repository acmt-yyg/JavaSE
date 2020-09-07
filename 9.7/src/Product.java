/**
 * @author YangYonggang on 2020/9/7 4:39 下午
 * @Description:do
 */
public class Product {

		private static int code = 1000;
		private String name;
		private double price;
		private int scanCode;
		private int num;

		/**
		 * 构造代码块，保证每一个Product对象的ScanCode是唯一的
		 */ {
				scanCode = code++;
		}

		public Product(String name, double price) {
				this.name = name;
				this.price = price;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public double getPrice() {
				return price;
		}

		public void setPrice(double price) {
				this.price = price;
		}

		public int getScanCode() {
				return scanCode;
		}

		public void setScanCode(int scanCode) {
				this.scanCode = scanCode;
		}

		public int getNum() {
				return num;
		}

		public void setNum(int num) {
				this.num = num;
		}

		/**
		 * 改变价格的方法
		 *
		 * @param price
		 */
		public void changePrice(double price) {
				this.price = price;
		}


		/**
		 * 买手机的方法
		 *
		 * @param num
		 * @return
		 */
		public boolean buy(int num) {
				if (num > this.num) {
						System.out.println("库存不足");
						return false;
				} else {
						this.num -= num;
						return true;
				}
		}

		/**
		 * 输出手机信息
		 *
		 * @return
		 */
		public String getInfo() {
				return "---产品信息---\n" +
				"名称：" + name + "\n" +
				"编码：" + scanCode + "\n" +
				"价格：" + price + "元" + "\n";
		}
}
