public class Fridge {

		private int heightInCM;
		private Elephant elephant;
		private Lion lion;

		public int getHeightInCM() {
				return heightInCM;
		}

		public void setHeightInCM(int heightInCM) {
				this.heightInCM = heightInCM;
		}

		public Elephant getElephant() {
				return elephant;
		}

		public void setElephant(Elephant elephant) {
				this.elephant = elephant;
		}

		public Lion getLion() {
				return lion;
		}

		public void setLion(Lion lion) {
				this.lion = lion;
		}

		/**
		 * 移除大象的方法
		 * @return
		 */
		Elephant remove() {
				Elephant a = elephant;
				elephant = null;
				return a;
		}

		/**
		 * 方法：输出冰箱的状态
		 */
		void printFridgeInfo() {
				if (elephant == null) {
						System.out.println("冰箱没有大象，是空的");
						return;
				}
				System.out.printf("%d厘米高的冰箱中，保存了一个%d厘米高的大象\n", heightInCM, elephant.getHeightInCM());
		}

		/**
		 * 方法：将大象放入冰箱中
		 * @param elephant
		 */
		public void store(Elephant elephant) {
				if (lion == null && this.elephant == null) {
						this.elephant = elephant;
				} else {
						System.out.println("冰箱已经满了");
				}
		}

		/**
		 * 方法：将狮子放入冰箱中
		 * @param lion
		 */
		public void store(Lion lion) {
				if (elephant == null && this.lion == null) {
						this.lion = lion;
				}else {
						System.out.println("冰箱已经满了");
				}
		}
}
