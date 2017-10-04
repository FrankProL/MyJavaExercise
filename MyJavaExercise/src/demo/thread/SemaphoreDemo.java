package demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/*
 * 信号量使用范例1
 */
public class SemaphoreDemo {
	public static void main(String[] args) {
		MyPool myPool=new MyPool(20);
		
		//创建线程池
		ExecutorService threadpool=Executors.newFixedThreadPool(2);
		
		MyThreads t1=new MyThreads("线程a", myPool, 10);
		MyThreads t2=new MyThreads("线程b", myPool, 12);
		MyThreads t3=new MyThreads("线程c", myPool, 7);
		
		//在线程池中执行任务
		threadpool.execute(t1);
		threadpool.execute(t2);
		threadpool.execute(t3);
		
		//关闭线程池
		threadpool.shutdown();
	}
}

/*
 * 定义一个池
 */
class MyPool{
	private Semaphore sp;	//池相关的信号量
	
	/*
	 * 池的大小，这个大小会传递给信号量
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
	private String threadname;		//线程名字
	private MyPool pool;			//自定义池
	private int x;					//申请信号量的大小
	
	public MyThreads(String threadname, MyPool pool, int x) {
		super();
		this.threadname = threadname;
		this.pool = pool;
		this.x = x;
	}
	
	@Override
	public void run() {
		try {
			//从信号量获取指定数目的许可
			pool.getSp().acquire(x);	//拿令牌
			
			//todo，也许这里可以做更复杂的业务
			System.out.println(threadname+"成功获取了"+x+"个许可");
			
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//释放给定数目的许可，将其放回到信号量
			pool.getSp().release(x);	//释放令牌
			System.out.println(threadname+"释放了"+x+"个许可");
		}
	}
	
}