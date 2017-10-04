package demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * �Զ����̳߳�
 * @author Frank
 *
 */
public class ThreadPoolDemo3 {
	public static void main(String[] args) {
		//�����ȴ����� 
		//��ָ��Ԫ����ӵ������У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ��
		BlockingQueue<Runnable> bqueue=new ArrayBlockingQueue<Runnable>(5);
		
		//�Զ����̳߳�
		//ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)
		ThreadPoolExecutor pool=new ThreadPoolExecutor(2, 3, 2, TimeUnit.MILLISECONDS, bqueue);
		
		//����ʵ��Runnable�ӿڵĶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1=new MyThread2();
		Thread t2=new MyThread2();
		Thread t3=new MyThread2();
		Thread t4=new MyThread2();
		Thread t5=new MyThread2();
		
		//���̷߳����̳߳�������
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		
		//�ر��̳߳�
		pool.shutdown();
	}
}

class MyThread2 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"����ִ��");
		
	}
}