package demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadReturnableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建一个线程池
		ExecutorService pool=Executors.newFixedThreadPool(3);
		
		/* 抽象类和接口不能直接实例化, 不能理解为抽象类型不能有对象，应该理解为抽象类不能直接被new出来，
		 * 它只能通过子类创建出来，jvm判断他是否能被实例时是根据被调用的那个类是否是它的子类来决定的。
		 * */
		//创建两个有返回值的任务
		Callable c1=new MyCallable("a");
		Callable c2=new MyCallable("b");
		
		//执行任务并获取Future对象
		Future f1=pool.submit(c1);
		Future f2=pool.submit(c2);
		
		//从Future对象获取任务的返回值，并输出到控制台
		System.out.println(">>>"+f1.get().toString());
		System.out.println(">>>"+f2.get().toString());
		
		//关闭线程池
		pool.shutdown();
	}
}

class MyCallable implements Callable{
	private String oid;
	
	public MyCallable(String oid) {
		super();
		this.oid = oid;
	}

	@Override
	public Object call() throws Exception {
		return oid+"任务返回的内容";
	}
	
}
