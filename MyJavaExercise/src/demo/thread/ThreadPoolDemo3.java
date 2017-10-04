package demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 自定义线程池
 * @author Frank
 *
 */
public class ThreadPoolDemo3 {
	public static void main(String[] args) {
		//创建等待队列 
		//将指定元素添加到队列中，如果没有可用空间，将一直等待（如果有必要）
		BlockingQueue<Runnable> bqueue=new ArrayBlockingQueue<Runnable>(5);
		
		//自定义线程池
		//ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)
		ThreadPoolExecutor pool=new ThreadPoolExecutor(2, 3, 2, TimeUnit.MILLISECONDS, bqueue);
		
		//创建实现Runnable接口的对象，Thread对象当然也实现了Runnable接口
		Thread t1=new MyThread2();
		Thread t2=new MyThread2();
		Thread t3=new MyThread2();
		Thread t4=new MyThread2();
		Thread t5=new MyThread2();
		
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

class MyThread2 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在执行");
		
	}
}