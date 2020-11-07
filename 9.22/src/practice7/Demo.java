package practice4;

/**
 * @author YangYonggang on 2020/9/22 4:33 下午
 * @Description:do
 */
public class Demo {

		/**
		 * 先有一个人A,有一部手机,等待别人打入
		 * 然后又两人(B,C) 要打电话给A
		 * 只要其中一个跟A通电话,那么这个人得到的回复是,电话占线中...请稍后在拨打...
		 * 如果电话结束,那么另一个人打电话的时候显示,正在接通,请等待...     已接通
		 */

		public static void main(String[] args) {
				Person person = new Person();
				person.setName("王五");
				CallPhonePerson phonePerson = new CallPhonePerson(person);

				PhonePersonA phonePerson1 = new PhonePersonA("张三", phonePerson);
				PhonePersonB phonePerson2 = new PhonePersonB("李四", phonePerson);
				phonePerson1.start();
				phonePerson2.start();
		}
}
