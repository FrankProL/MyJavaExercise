package demo.thread;

public class WaitDemo1 {
	public static void main(String[] args) {
		ThreadB b= new ThreadB();
		
		b.start();
		//线程A拥有b对象上的锁
		//线程为了调用wait()或notify()方法，该线程必须是那个对象的拥有者
		synchronized (b) {
			try {
				System.out.println("等待b完成计算");
				b.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			System.out.println("b对象计算的总和是："+b.total);
		}
	}
}
/*
 * 计算1到100的和
 */
class ThreadB extends Thread{
	int total;
	@Override
	public void run() {
		synchronized (this) {
			for(int i=0;i<101;i++){
				total+=i;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			//计算完成后，唤醒在此对象监视器上等待的单个线程，本例中线程A被唤醒
			notify();
		}
	}
}