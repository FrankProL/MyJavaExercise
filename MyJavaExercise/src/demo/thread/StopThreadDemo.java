package demo.thread;
/*
 * 线程终止示例---推荐使用（使用while循环，设置状态标识）
 */
public class StopThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		CanStopRunner runner=new CanStopRunner();
		Thread t=new Thread(runner);
		t.start();
		Thread.sleep(1000);
		runner.stop();			//t.stop();已不推荐使用
	}
}

class CanStopRunner implements Runnable{
	private boolean stop=false;	//设置状态标识，退出标识
	@Override
	public void run() {
		while (!stop) {			//不断的运行，直到状态标识改变
			System.out.println("正在运行中。。。");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//改变状态标记，使线程终止
	public void stop(){
		stop=true;
	}
}