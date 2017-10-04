package demo.thread;
/*
 * Java�в����̵߳ĵڶ��ַ�ʽ���Ƽ���ʽ��
 * ͨ��runnable�ӿڣ�ʵ�ֶ��߳�
 * 1.ͨ���̳�Thread��ʵ�ֶ��߳�ʱ���߳�����޷��ټ̳�������ʵ������һЩ���ܣ�ͨ��ʵ�ֽӿڵķ�ʽ��û����Щ����
 * 2.ͨ��ʵ��Runnable�ӿڵķ�ʽ���Դﵽ��Դ�����Ч��
 */
public class SecondThread {
	public static void main(String[] args) {
		HelloRunner r=new HelloRunner(100);
		Thread t1=new Thread(r,"thread one");	//�ڶ���������ʡ��ָ���߳�����
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