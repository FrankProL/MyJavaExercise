package demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadReturnableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//����һ���̳߳�
		ExecutorService pool=Executors.newFixedThreadPool(3);
		
		/* ������ͽӿڲ���ֱ��ʵ����, �������Ϊ�������Ͳ����ж���Ӧ�����Ϊ�����಻��ֱ�ӱ�new������
		 * ��ֻ��ͨ�����ഴ��������jvm�ж����Ƿ��ܱ�ʵ��ʱ�Ǹ��ݱ����õ��Ǹ����Ƿ������������������ġ�
		 * */
		//���������з���ֵ������
		Callable c1=new MyCallable("a");
		Callable c2=new MyCallable("b");
		
		//ִ�����񲢻�ȡFuture����
		Future f1=pool.submit(c1);
		Future f2=pool.submit(c2);
		
		//��Future�����ȡ����ķ���ֵ�������������̨
		System.out.println(">>>"+f1.get().toString());
		System.out.println(">>>"+f2.get().toString());
		
		//�ر��̳߳�
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
		return oid+"���񷵻ص�����";
	}
	
}
