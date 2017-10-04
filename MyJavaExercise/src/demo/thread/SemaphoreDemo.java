package demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/*
 * �ź���ʹ�÷���1
 */
public class SemaphoreDemo {
	public static void main(String[] args) {
		MyPool myPool=new MyPool(20);
		
		//�����̳߳�
		ExecutorService threadpool=Executors.newFixedThreadPool(2);
		
		MyThreads t1=new MyThreads("�߳�a", myPool, 10);
		MyThreads t2=new MyThreads("�߳�b", myPool, 12);
		MyThreads t3=new MyThreads("�߳�c", myPool, 7);
		
		//���̳߳���ִ������
		threadpool.execute(t1);
		threadpool.execute(t2);
		threadpool.execute(t3);
		
		//�ر��̳߳�
		threadpool.shutdown();
	}
}

/*
 * ����һ����
 */
class MyPool{
	private Semaphore sp;	//����ص��ź���
	
	/*
	 * �صĴ�С�������С�ᴫ�ݸ��ź���
	 */
	MyPool(int size) {
		this.sp = new Semaphore(size);
	}

	public Semaphore getSp() {
		return sp;
	}

	public void setSp(Semaphore sp) {
		this.sp = sp;
	}
}

class MyThreads extends Thread{
	private String threadname;		//�߳�����
	private MyPool pool;			//�Զ����
	private int x;					//�����ź����Ĵ�С
	
	public MyThreads(String threadname, MyPool pool, int x) {
		super();
		this.threadname = threadname;
		this.pool = pool;
		this.x = x;
	}
	
	@Override
	public void run() {
		try {
			//���ź�����ȡָ����Ŀ�����
			pool.getSp().acquire(x);	//������
			
			//todo��Ҳ����������������ӵ�ҵ��
			System.out.println(threadname+"�ɹ���ȡ��"+x+"�����");
			
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//�ͷŸ�����Ŀ����ɣ�����Żص��ź���
			pool.getSp().release(x);	//�ͷ�����
			System.out.println(threadname+"�ͷ���"+x+"�����");
		}
	}
	
}