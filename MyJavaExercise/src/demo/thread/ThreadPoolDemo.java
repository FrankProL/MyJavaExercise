package demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * FixedThreadPool�̶���С�̳߳�
 * SingleThreadExecutor�޽���У�����˳��ִ���̳߳�
 * CachedThreadPool�ɱ��С�����贴�����̳߳�
 * @author Frank
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		//����һ���̶���С�Ŀ������̳߳�
		//ExecutorService pool = Executors.newFixedThreadPool(3);
		
		//����һ��ʹ�õ���worker�̵߳�Executor�����޽���з�ʽ�����и��߳�
		//�����̳߳أ�����û�д�С���ƣ���˳��ִ�У��ܱ���֤�߳��������ִ��
		//ExecutorService pool=Executors.newSingleThreadExecutor();
		
		//����һ���ɸ�����Ҫ�������̵߳��̳߳أ�������ǰ������߳̿���ʱ����������
		ExecutorService pool=Executors.newCachedThreadPool();
		
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
		pool.execute(t4);
		pool.execute(t5);
		
		//�ر��̳߳�
		pool.shutdown();
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"����ִ��");
		
	}
}