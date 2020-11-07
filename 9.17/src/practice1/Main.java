package practice1;

/**
 * @author YangYonggang on 2020/9/17 3:49 下午
 * @Description:do
 */
public class HighSchoolStudent<K, V> extends Student<K, V> {

		public HighSchoolStudent(K k, V i) {
				super(k, i);
		}

		public static void main(String[] args) {

				HighSchoolStudent<String, Integer> highSchoolStudent = new HighSchoolStudent<>("张三", 100);
				System.out.println(highSchoolStudent);

				Student<String, Integer> student = new Student<String, Integer>("张三", 90);
				System.out.println(student);

		}
}
