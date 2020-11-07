import java.util.Scanner;

/**
 * @author YangYonggang on 2020/9/28 10:22 上午
 * @Description:do
 */
public class VendingMachine {

		public static void main(String[] args) {

				System.out.println("*-------------------------*");
				System.out.println("|     Vending Machine     |");
				System.out.println("*-------------------------*");
				System.out.println("|  A    B    C    D    E  |");
				System.out.println("| $10  $ 6  $ 5  $ 8  $ 7 |");
				System.out.println("| [ ]  [ ]  [ ]  [ ]  [ ] |");
				System.out.println("*-------------------------*");
				System.out.println("|                   [$ 0] |");
				System.out.println("|                         |");
				System.out.println("|          [===]          |");
				System.out.println("*-------------------------*");

				int[] num = {1, 2, 3, 4, 9, 0};
				for (int i = 0; i < num.length; i++) {
						System.out.println("What would you like do？");
						System.out.println("1.Read product information");
						System.out.println("2.Insert coin");
						System.out.println("3.Press product button");
						System.out.println("4.Press return button");
						System.out.println("9.Open service menu (code required)");
						System.out.println("0.Quit");

						Scanner scanner = new Scanner(System.in);
						String input = scanner.nextLine();

						if (num[i] != Integer.parseInt(input)) {
								System.out.println("Invalid choice!");
						} else {
								System.out.println("Your choice:" + input);
								switch (input) {
										case "1":
												readProductInformation();
												break;
										case "2":
												insertCoin();
												break;
										case "3":
												pressProductButton();
												break;
										case "4":
												pressReturnButton();
								}
						}
				}
		}




		public static void readProductInformation() {
				System.out.println("(1) The displayed products are:");
				System.out.println("A. Juice ($10)");
				System.out.println("B. Cola ($6)");
				System.out.println("C. Tea ($5)");
				System.out.println("D. Water ($8)");
				System.out.println("E. Coffee ($7)");
		}

		public static void insertCoin() {
				System.out.println("(2) Which coin would you like to insert?");
				System.out.println("1.$1");
				System.out.println("2.$2");
				System.out.println("3.$5");
				System.out.println("4.$10");
				System.out.println("0.Go back");
		}

		private static void pressProductButton() {
				System.out.println("(3) Which product button would you like to press?");
				System.out.println("1.A");
				System.out.println("2.B");
				System.out.println("3.C");
				System.out.println("4.D");
				System.out.println("5.E");
				System.out.println("0.Go back");
		}

		private static void pressReturnButton() {
		}
}
