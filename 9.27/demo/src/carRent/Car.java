package carRent;

/**
 * @author YangYonggang on 2020/9/27 9:13 上午
 * @Description:do
 */
public class Car extends Vehicle {

		int seats;

		public Car(int year, String vendor, int seats) {
				super(year, vendor);
				this.seats = seats;
		}

		@Override
		public String toString() {
				return year + "年" + vendor + "客车，载客量为" + seats + "位，" + (isRent ? "已出租" : "未出租");
		}
}
