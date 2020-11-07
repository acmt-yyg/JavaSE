package practice4;

import java.util.concurrent.Semaphore;

/**
 * @author YangYonggang on 2020/9/22 4:33 下午
 * @Description:do
 */
public class Person {

		private String  name;
		private  boolean flag =false ;//是否在打电话

		Semaphore semaphore = new Semaphore(1);//使用信号量的方式 一次只能接入一个

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public boolean isFlag() {
				return flag;
		}

		public void setFlag(boolean flag) {
				this.flag = flag;
		}
}
