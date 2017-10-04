package demo.thread;
/*
 * wait()、notify()使用范例
 */
public class WaitDemo2 {
	public static void main(String[] args) {
		final String mutex="去北京";
		//司机线程
		final Thread driver=new Thread(){
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println("正在开车去目的地的路上。。");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				System.out.println("司机到达目的地了");
				synchronized (mutex) {
					System.out.println("司机叫醒乘客");
					mutex.notify();
				}
				
			}
		};
		//乘客线程
		Thread passager=new Thread(){
			@Override
			public void run() {
				synchronized (mutex) {
					System.out.println("告诉司机出发");
					driver.start();
					try {
						System.out.println("准备休息了");
						mutex.wait();
						System.out.println("到达北京，开始参观");
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
			}
		};
		passager.start();
	}
}
