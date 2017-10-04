package demo.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
/*
 * java线程--信号量
 */
public class SemaphoreDemo2 {
	public static void main(String[] args) {
		Runnable runner=new Runnable() {	//匿名内部类
			Random ran=new Random();
			Semaphore signal=new Semaphore(3);
			
			@Override
			public void run() {
				int time=ran.nextInt(10);
				
				try {
					signal.acquire();
					
					String name=Thread.currentThread().getName();
					System.out.println(name+"正在运行，需等待"+time+"秒");
					Thread.sleep(time*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				signal.release();
			}
		};
		for(int i=0;i<10;i++){
			new Thread(runner).start();
		}
	}
}
