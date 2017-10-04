package cn.android.j2se.core.thread;
/**
 * 这是第一种使用线程的例子(不推荐使用)
 * @author jhao
 *
 */
public class FirstThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HelloThread t = new HelloThread(100);
		t.start();
		//t.run();
		
		System.out.println(Thread.currentThread().getName());
	}

}

class HelloThread extends Thread {
	private long max;

	public HelloThread(long max) {
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i < max; i++) {
			System.out.println(Thread.currentThread().getName() + "========>"
					+ i);
		}
	}
}
