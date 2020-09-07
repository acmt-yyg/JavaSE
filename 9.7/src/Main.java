/**
 * @author YangYonggang on 2020/9/7 5:01 下午
 * @Description:do
 */
public class Main {

		public static void main(String[] args) {

				Product p1 = new Product("手机", 2000);
				Product p2 = new Product("电脑", 10000);

				System.out.println(p1.getInfo());
				System.out.println(p2.getInfo());

				p1.setNum(10);
				p2.setNum(100);

				System.out.println(p1.buy(6));
				System.out.println();
				System.out.println(p1.buy(6));
				System.out.println();

				System.out.println(p2.buy(60));
				System.out.println();
				System.out.println(p2.buy(40));
				System.out.println();

				p1.changePrice(3000);
				System.out.println(p1.getInfo());
		}
}
