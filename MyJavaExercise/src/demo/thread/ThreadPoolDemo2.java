package demo.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * ScheduledThreadPool���趨�ӳٻ���ִ��
 * @author Frank
 *
 */
public class ThreadPoolDemo2 {
	public static void main(String[] args) {
		
		//����һ���̳߳أ������԰����ڸ����ӳٺ������������ִ��
		ScheduledExecutorService pool=Executors.newScheduledThreadPool(2);
		
		//����ʵ��Runnable�ӿڵĶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1=new MyThread1();
		Thread t2=new MyThread1();
		Thread t3=new MyThread1();
		Thread t4=new MyThread1();
		Thread t5=new MyThread1();
		
		//���̷߳����̳߳�������
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		//ʹ���ӳ�ִ�з��ķ���
		pool.schedule(t4, 10, TimeUnit.SECONDS);
		pool.schedule(t5, 20, TimeUnit.SECONDS);
		
		//�ر��̳߳�
		pool.shutdown();
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"����ִ��");
		
	}
}