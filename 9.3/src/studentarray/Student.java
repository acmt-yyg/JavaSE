package studentarray;

/**
 * @author YangYonggang on 2020/9/4 12:43 下午
 * @Description:do
 */
public class Student {

		private int id;
		private String name;
		private Double score;

		public Student() {
		}

		public Student(int id, String name, Double score) {
				this.id = id;
				this.name = name;
				this.score = score;
		}

		public int getId() {
				return id;
		}

		public void setId(int id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public Double getScore() {
				return score;
		}

		public void setScore(Double score) {
				this.score = score;
		}

		@Override
		public String toString() {
				return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", score=" + score +
				'}';
		}
}
