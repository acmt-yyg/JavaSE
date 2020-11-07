package carRent;

import java.util.Scanner;

/**
 * @author YangYonggang on 2020/9/27 9:24 上午
 * @Description:do
 */
public class Main {

		// 用数组存储车辆
		static Vehicle[] vehicles = new Vehicle[10];
		// 车位计数器
		static int carCount;
		// 接收键盘输入
		static Scanner scanner = new Scanner(System.in);


		public static void main(String[] args) {

				System.out.println("欢迎使用半圆租车系统");

				while (true) {
						// ※起始位置
						// 打印菜单
						System.out.println("================");
						System.out.println("1. 添加车辆");
						System.out.println("2. 查询车辆");
						System.out.println("3. 出租车辆");
						System.out.println("4. 归还车辆");
						System.out.println("0. 退出系统");

						// 接收用户输入
						Scanner scanner = new Scanner(System.in);
						System.out.println("请输入：");
						String input = scanner.nextLine();

						// 分支选择流程
						switch (input) {
								case "1":
										// 添加车辆
										addVehicle();
										break; // break语句相当于结束switch代码内容，结束之后，将返回到 ※起始位置 开始执行
								case "2":
										// 打印车辆信息
										printInfo();
										break;
								case "3":
										// 出租车辆
										rentVehicle();
										break;
								case "4":
										// 归还车辆
										returnVehicle();
										break;
								case "0":
										// 退出
										System.out.println("谢谢使用，再见！");
										return;
								default:
										// 输入有误, 代码执行到这里之后将会返回到 ※起始位置 再次开始执行
										System.out.println("输入不合法！请重新输入");
						}
				}
		}


		/**
		 * 添加车辆
		 */
		private static void addVehicle() {
				System.out.println("添加车辆流程");
				System.out.println("-----------");

				while (true) {
						System.out.println("请输入车辆年份(4位数年份)：");
						int year = scanner.nextInt();
						scanner.nextLine();
						if (year < 1000 || year > 9999) {
								System.out.println("输入不合法！");
								continue;
						}

						System.out.println("请输入车辆厂家：");
						String vendor = scanner.nextLine();

						System.out.println("请输入要添加的车辆类型 1.客车 2.货车");
						String vehicleType = scanner.nextLine();
						if ("1".equals(vehicleType)) {
								System.out.println("请输入客车载客量：");
								int seats = scanner.nextInt();
								vehicles[carCount++] = new Car(year, vendor, seats);
						} else if ("2".equals(vehicleType)) {
								System.out.println("请输入货车载货量：");
								int load = scanner.nextInt();
								vehicles[carCount++] = new Truck(year, vendor, load);
						} else {
								System.out.println("输入不合法！");
								continue;
						}
						System.out.println("添加成功");
						break;
				}
		}


		/**
		 * 打印车辆信息
		 */
		private static void printInfo() {
				System.out.println("打印车辆信息流程");
				System.out.println("-----------");
				for (int i = 0; i < carCount; i++) {
						System.out.println(i + 1 + "." + vehicles[i]);
				}
		}


		/**
		 * 出租车辆
		 */
		private static void rentVehicle() {
				System.out.println("出租车辆流程");
				System.out.println("-----------");

				System.out.println("请选择租用的车辆编号(0返回上一级)：");

				while (true) {
						int vehicleId = scanner.nextInt() - 1; // 数组下标从0开始
						if (vehicleId >= carCount || vehicleId < 0 || vehicles[vehicleId].isRent) {
								System.out.println("输入不合法！");
						} else {
								vehicles[vehicleId].isRent = true;
								System.out.println("出租成功");
								break;
						}
				}
		}


		/**
		 * 归还车辆
		 */
		private static void returnVehicle() {
				System.out.println("归还车辆流程");
				System.out.println("-----------");

				System.out.println("请选择租用的车辆编号(0返回上一级)：");

				while (true) {
						int vehicleId = scanner.nextInt() - 1; // 数组下标从0开始
						if (vehicleId >= carCount || vehicleId < 0 || !vehicles[vehicleId].isRent) {
								System.out.println("输入不合法！");
						} else {
								vehicles[vehicleId].isRent = false;
								System.out.println("归还成功");
								break;
						}
				}
		}
}