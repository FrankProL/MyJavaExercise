package demo.thread;
/*
 * Java中操作线程的第二种方式（推荐方式）
 * 通过runnable接口，实现多线程
 * 1.通过继承Thread类实现多线程时，线程类就无法再继承其他类实现其他一些功能，通过实现接口的方式则没有这些限制
 * 2.通过实现Runnable接口的方式可以达到资源共享的效果
 */
public class SecondThread {
	public static void main(String[] args) {
		HelloRunner r=new HelloRunner(100);
		Thread t1=new Thread(r,"thread one");	//第二个参数可省，指定线程名字
		Thread t2=new Thread(r,"thread two");
		t1.start();
		t2.start();
	}
}

class HelloRunner implements Runnable{
	private long max;

	public HelloRunner(long max) {
		super();
		this.max = max;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<max;i++){
			System.out.println(Thread.currentThread().getName()+"---"+i);
		}
		
	}
	
}