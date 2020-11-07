package practice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YangYonggang on 2020/9/22 2:16 下午
 * @Description:do
 */
public class LockDemo {

		/**
		 * 同步的前提
		 * 多个线程
		 * 多个线程使用的是同一个锁对象
		 * 同步的好处
		 * 同步的出现解决了多线程的安全问题。
		 * 同步的弊端
		 * 当线程相当多时，因为每个线程都会去判断同步上的锁，这是很耗费资源的，无形中会降低程序的运行效率
		 * <p>
		 * Lock 锁  和 synchronized  对比
		 * 1. synchronized内置java关键字在jvm层,lock是个java类 是 jdk层的
		 * 2. synchronized无法判断是否获取锁的状态,lock可以判断是否获取锁
		 * 3. synchronized会自动释放锁,lock必须手动释放锁(unlock()在finally释放) 否则会造成死锁
		 * 4. 使用synchronized的两个线程A和B 如果线程A 获得了锁,那么B一定在等待中.如果线程A阻塞了,则线程B
		 * 会一直等待下去,lock不一定会等待，如果尝试回去不到锁,线程不会等待,直接结束
		 * 5.synchronized适合少量的代码同步,Lock比较适合大量的同步代码的问题
		 */


		public static void main(String[] args) {
				final MyThread myThread = new MyThread();
				Thread t = new Thread(() -> {
						try {
								myThread.lockTesNotWait(Thread.currentThread());
						} catch (Exception e) {
								e.printStackTrace();
						}
				}, "线程A");

				Thread t1 = new Thread(() -> {
						try {
								myThread.lockTes(Thread.currentThread());
						} catch (Exception e) {
								e.printStackTrace();
						}
				}, "线程B");
				t.start();
				t1.start();
		}
}


class MyThread {

		private Lock lock = new ReentrantLock();

		public void lockTes(Thread thread) throws InterruptedException {

				lock.lock();// 获取锁

				System.out.println(thread.getName() + "进来了，获取了当前锁..." + lock.tryLock());
				Thread.sleep(1000);
				System.out.println(thread.getName() + "发生了异常，释放了锁...");
				lock.unlock();// 主动释放锁
				System.out.println(thread.getName() + "正常执行完毕，释放了锁...");
		}

		public void lockTesNotWait(Thread thread) throws InterruptedException {

				if (lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
						System.out.println(thread.getName() + "进来了，获取了当前锁...");
						Thread.sleep(1000);
						System.out.println(thread.getName() + "发生了异常，释放了锁...");
						lock.unlock();// 主动释放锁
						System.out.println(thread.getName() + "正常执行完毕，释放了锁...");
				} else {
						System.out.println(thread.getName() + "没有获取到锁，被其他线程占用了...");
				}
		}
}
