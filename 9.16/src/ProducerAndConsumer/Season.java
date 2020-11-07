package practice2;

/**
 * @author YangYonggang on 2020/9/16 2:41 下午
 * @Description:do
 */
public enum Season {
		春, 夏, 秋, 冬;

		public void getMonthRange() {
				System.out.println(this);
		}

		@Override
		public String toString() {
				switch (this) {
						case 春:
								return "3~5";
						case 夏:
								return "6~8";
						case 秋:
								return "9~11";
						case 冬:
								return "12~2";
						default:
								return null;
				}
		}
}
