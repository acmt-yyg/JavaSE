package practice02;

/**
 * @author YangYonggang on 2020/9/5 2:41 下午
 * @Description:5.编写一个方法输入分钟时间，向控制台输出多少年，多少天 3456789 分钟
 * 3456789 分钟是6年210天
 * void convert(long minute)
 */
public class Convert {

		/**
		 * 时间转换方法
		 * @param minute
		 */
		public static void convert(long minute) {
				long years = minute / (365 * 24 * 60);
				int days = (int) (minute / (24 * 60)) % 365;
				System.out.printf("%d分钟是%d年%d天", minute, years, days);
		}

		public static void main(String[] args) {
				convert(3456789L);
		}
}
