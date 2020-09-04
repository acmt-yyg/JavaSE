/**
 * 作业1
 * 1.抄写一份Hello.java放到当前路径下，编译运行Hello.java，请记录打开终端开始到程序运行期间所有输入的终端命令
 *   cd ~/JAVA/javase/9.3/src
 *   javac HelloJava.java
 *   java HelloJava
 * 2.将编译生成的Hello.class文件删除，编辑Hello.java将class后面的名称修改为test，然后编译Hello.java文件
 *   生成的class文件名是什么
 *   test.class
 *   请尝试使用java运行编译后的文件，应该输入什么命令
 *   java test
 * 3.保持上一题的状态，编辑Hello.java将class后面的名称修改为Test，然后编译Hello.java
 *   是否生成新的class文件
 *   不会生成新的
 *   请尝试使用java运行编译后的文件，应该输入什么命令
 *   java Test
 *   将test.class 重命名为test1.class后尝试运行，是否可以运行成功，如果不成功记录错误
 *   不可以。记录：找不到或无法加载主类 test
 *   原因：java.lang.ClassNotFoundException: test
 *   将test.class 重命名为TEST.class尝试运行，是否可以运行成功，如果不成功记录错误
 *   java Test
 * 4.仿照Hello.java写一个HelloWorld.java, 其中class声明为HelloWorld，向屏幕输出Hello World!
 *   public class HelloWorld {
 *
 * 		public static void main(String[] args) {
 * 				System.out.println("Hello Java!");
 *    }
 *   }
 */




