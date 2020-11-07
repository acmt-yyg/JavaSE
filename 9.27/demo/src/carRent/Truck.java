package carRent;

/**
 * @author YangYonggang on 2020/9/27 9:19 上午
 * @Description:do
 */
public class Truck extends Vehicle {

		int load;

		public Truck(int year, String vendor, int load) {
				super(year, vendor);
				this.load = load;
		}

		@Override
		public String toString() {
				return year + "年" + vendor + "货车，载重量为" + load + "吨，" + (isRent ? "已出租" : "未出租");
		}
}
