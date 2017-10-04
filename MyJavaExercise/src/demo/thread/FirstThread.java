package demo.thread;
/*
 * �̳�Thread��
 */
public class FirstThread {
	public static void main(String[] args) {
		HelloThread t=new HelloThread(100);
		t.start();		//�����߳�start����������run
//		t.run();		//������ͨ������û�п������߳�
		
		System.out.println(Thread.currentThread().getName());
	}
}

class HelloThread extends Thread {
	private long max;

	public HelloThread(long max) {
		super();
		this.max = max;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < max; i++) {
			System.out.println(Thread.currentThread().getName() + "---"+i);
		}
	}

}