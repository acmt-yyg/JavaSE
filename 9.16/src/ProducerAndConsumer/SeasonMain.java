package practice2;

/**
 * @author YangYonggang on 2020/9/16 4:17 下午
 * @Description:do
 */
public class SeasonMain {

		public static void main(String[] args) {

				for (Season season : Season.values()) {
						season.getMonthRange();
				}
		}
}
