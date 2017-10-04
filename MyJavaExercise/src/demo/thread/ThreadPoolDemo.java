package demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * FixedThreadPool固定大小线程池
 * SingleThreadExecutor无界队列，单个顺序执行线程池
 * CachedThreadPool可变大小（按需创建）线程池
 * @author Frank
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		//创建一个固定大小的可重用线程池
		//ExecutorService pool = Executors.newFixedThreadPool(3);
		
		//创建一个使用单个worker线程的Executor，以无界队列方式来运行该线程
		//单个线程池，队列没有大小限制，按顺序执行，能报保证线程有序逐个执行
		//ExecutorService pool=Executors.newSingleThreadExecutor();
		
		//创建一个可根据需要创建新线程的线程池，但是以前构造的线程可用时将重用他们
		ExecutorService pool=Executors.newCachedThreadPool();
		
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
		pool.execute(t4);
		pool.execute(t5);
		
		//关闭线程池
		pool.shutdown();
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在执行");
		
	}
}