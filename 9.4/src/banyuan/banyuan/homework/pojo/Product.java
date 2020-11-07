package club.banyuan.homework.pojo;

import java.util.Arrays;

/**
 * 产品类
 *
 * @author sanye
 * @version 1.0
 * @date 2020/9/4 3:48 下午
 */
public class Product {

		private String proId;
		private String proName;
		//负责该产品的研发人员 又可能是多个人
		private Employee[] employee;

		@Override
		public String toString() {
				return "Product{" +
				"proId='" + proId + '\'' +
				", proName='" + proName + '\'' +
				", employee=" + Arrays.toString(employee) +
				'}';
		}
}
