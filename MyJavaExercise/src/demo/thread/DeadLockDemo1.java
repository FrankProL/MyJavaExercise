package demo.thread;
/*
 * 死锁范例1
 */
public class DeadLockDemo1 {
	public static void main(String[] args) {
		System.out.println("主线程开始");
		final StringBuffer mutex=new StringBuffer("ABCD");
		
		Thread t =new Thread(){		//匿名内部类
			public void run() {
				System.out.println("子线程开始");
				synchronized (mutex) {
					mutex.reverse();
				}
				System.out.println(mutex);
				System.out.println("子线程结束");
			}
		};
		
		t.start();
		
		synchronized (mutex) {
			System.out.println("进入同步锁");
			//此时主线程已获取同步锁，此时t.join将子线程加入让其执行，子线程等待主线程释放同步锁，主线程等待子线程执行
//			try{
//				t.join();
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
			System.out.println(mutex);
		}
		
		System.out.println("主线程结束");
	}
}
