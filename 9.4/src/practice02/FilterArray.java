package practice02;

import java.util.Arrays;

/**
 * @author YangYonggang on 2020/9/5 3:41 下午
 * @Description:7.编写一个方法用于int数组去重，将数组中重复的元素只保留一个 int [] filterArray(int[]){
 * <p>
 * }
 */
public class FilterArray {

		static int[] filterArray(int[] arr) {
				int count = arr.length;
				for (int i = 0; i < count; i++) {
						for (int j = i + 1; j < count; j++) {
								if (arr[i] == arr[j]) {
										arr[j] = arr[count - 1];
										count--;
										j--;
								}
						}
				}

				int[] res = new int[count];
				for (int i = 0; i < count; i++) {
						res[i] = arr[i];
				}

				System.out.printf("[");
				for (int one : res) {
						System.out.printf("%d, ", one);
				}
				System.out.printf("]");

				return res;
		}

		public static void main(String[] args) {
				int[] arr = new int[]{2, 4, 0, 8, -2, 4, 6, 7, 2, 12};
				System.out.println(Arrays.toString(arr));
				filterArray(arr);
		}
}
