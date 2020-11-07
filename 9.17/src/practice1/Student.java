package practice1;

/**
 * @author YangYonggang on 2020/9/17 3:47 下午
 * @Description:do
 */
public class Student<K, V> {

		private K k;
		private V v;

		public Student(K k, V i) {
		}

		public K getK() {
				return k;
		}

		public void setK(K k) {
				this.k = k;
		}

		public V getV() {
				return v;
		}

		public void setV(V v) {
				this.v = v;
		}

		@Override
		public String toString() {
				return "Student{" +
				"k=" + k +
				", v=" + v +
				'}';
		}
}
