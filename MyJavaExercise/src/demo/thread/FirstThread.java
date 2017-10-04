package demo.thread;
/*
 * 继承Thread类
 */
public class FirstThread {
	public static void main(String[] args) {
		HelloThread t=new HelloThread(100);
		t.start();		//启动线程start（），不是run
//		t.run();		//当做普通方法，没有开辟新线程
		
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