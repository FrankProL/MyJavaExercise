package demo.thread;
/*
 * ��������1
 */
public class DeadLockDemo1 {
	public static void main(String[] args) {
		System.out.println("���߳̿�ʼ");
		final StringBuffer mutex=new StringBuffer("ABCD");
		
		Thread t =new Thread(){		//�����ڲ���
			public void run() {
				System.out.println("���߳̿�ʼ");
				synchronized (mutex) {
					mutex.reverse();
				}
				System.out.println(mutex);
				System.out.println("���߳̽���");
			}
		};
		
		t.start();
		
		synchronized (mutex) {
			System.out.println("����ͬ����");
			//��ʱ���߳��ѻ�ȡͬ��������ʱt.join�����̼߳�������ִ�У����̵߳ȴ����߳��ͷ�ͬ���������̵߳ȴ����߳�ִ��
//			try{
//				t.join();
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
			System.out.println(mutex);
		}
		
		System.out.println("���߳̽���");
	}
}
