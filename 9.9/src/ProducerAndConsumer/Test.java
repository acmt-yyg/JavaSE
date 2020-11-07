package practice2;

/**
 * @author YangYonggang on 2020/9/10 4:52 下午
 * @Description:do
 */
public class Test {

		public static void main(String[] args) {

				Student s1 = new PrimaryStudent("小学生");
				Student s2 = new MiddleStudent("中学生");
				Student s3 = new HighStudent("高中生");

        s1.study();
        s2.study();
        s3.study();

		}
}
