package practice8;

import java.io.File;

/**
 * @author YangYonggang on 2020/9/23 4:05 下午
 * @Description:do
 */
public class FielDemo {


		public static void main(String[] args) {

				File file = new File("practice9.md");

				System.out.println(file.getAbsolutePath());

				System.out.println(file.getPath());

				System.out.println(file.exists());

				System.out.println(file.getParentFile());

				System.out.println(file.mkdir());

				System.out.println(file.mkdirs());

				System.out.println(file.getParent());
		}
}
