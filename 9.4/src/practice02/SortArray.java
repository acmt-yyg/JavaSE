package practice02;

/**
 * @author YangYonggang on 2020/9/4 12:51 下午
 * @Description:do
 */
public class SortArray {

		/**
		 * 1.编写一个sortArr方法
		 *   根据传入的参数来将数组升序或降序排列
		 *
		 * @param isAsc true 升序， false 降序
		 * @param arr
		 */
		static void sort(int[] arr, boolean isAsc) {
				for (int i = 0; i < arr.length; i++) {
						for (int j = 0; j < arr.length - i - 1; j++) {
								if (isAsc) {
										if (arr[j] > arr[j + 1]) {
												int temp = arr[j + 1];
												arr[j + 1] = arr[j];
												arr[j] = temp;
										}
								} else {
										if (arr[j] < arr[j + 1]) {
												int temp = arr[j + 1];
												arr[j + 1] = arr[j];
												arr[j] = temp;
										}
								}

						}
				}
		}

		/**
		 * 2.重载上述的sortArr方法，用来实现数组升序排列
		 * 重载方法，将数组升序
		 *
		 * @param arr
		 */
		static void sort(int arr[]) {
				for (int i = 0; i < arr.length; i++) {
						for (int j = 0; j < arr.length - i - 1; j++) {
								if (arr[j] > arr[j + 1]) {
										int temp = arr[j + 1];
										arr[j + 1] = arr[j];
										arr[j] = temp;
								}
						}
				}
				sort(arr,true);
		}

		/**
		 * 3.编写一个main方法用来测试上述两个方法，定义一个数组，内容 {13,26,-3,4,54,26,37,18,69,-10}，
		 * 编写一个print方法，使用字符串拼接的方式，将数组内容数组输出为如下格式，每5个换行
		 * [0]=13 [1]=26 [2]=-1 [3]=4 [4]=54
		 * [5]=26 ....
		 *
		 * @param arr
		 */
		public static void printArr(int[] arr) {
				for (int i = 0; i < arr.length; i++) {
						System.out.printf("[%d]=%d  ", i, arr[i]);
						if ((i + 1) % 5 == 0) {
								System.out.println();
						}
				}
		}

		/**
		 * 测试用例
		 * @param args
		 */
		public static void main(String[] args) {

				int[] arr = {13, 26, -3, 4, 54, 26, 37, 18, 69, -10};
				System.out.println("原始顺序");
				printArr(arr);
				System.out.println();
				System.out.println("降序排列");
				sort(arr, false);
				printArr(arr);
				System.out.println();
				System.out.println("升序排列");
				sort(arr);
				printArr(arr);
		}
}
