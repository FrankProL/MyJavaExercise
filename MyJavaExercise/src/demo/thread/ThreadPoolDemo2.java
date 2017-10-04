package demo.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * ScheduledThreadPool可设定延迟或定期执行
 * @author Frank
 *
 */
public class ThreadPoolDemo2 {
	public static void main(String[] args) {
		
		//创建一个线程池，它可以安排在给定延迟后运行命令，或定期执行
		ScheduledExecutorService pool=Executors.newScheduledThreadPool(2);
		
		//创建实现Runnable接口的对象，Thread对象当然也实现了Runnable接口
		Thread t1=new MyThread1();
		Thread t2=new MyThread1();
		Thread t3=new MyThread1();
		Thread t4=new MyThread1();
		Thread t5=new MyThread1();
		
		//将线程放入线程池中运行
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		//使用延迟执行风格的方法
		pool.schedule(t4, 10, TimeUnit.SECONDS);
		pool.schedule(t5, 20, TimeUnit.SECONDS);
		
		//关闭线程池
		pool.shutdown();
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在执行");
		
	}
}