package demo.thread;
/*
 * wait()��notify()ʹ�÷���
 */
public class WaitDemo2 {
	public static void main(String[] args) {
		final String mutex="ȥ����";
		//˾���߳�
		final Thread driver=new Thread(){
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println("���ڿ���ȥĿ�ĵص�·�ϡ���");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				System.out.println("˾������Ŀ�ĵ���");
				synchronized (mutex) {
					System.out.println("˾�����ѳ˿�");
					mutex.notify();
				}
				
			}
		};
		//�˿��߳�
		Thread passager=new Thread(){
			@Override
			public void run() {
				synchronized (mutex) {
					System.out.println("����˾������");
					driver.start();
					try {
						System.out.println("׼����Ϣ��");
						mutex.wait();
						System.out.println("���ﱱ������ʼ�ι�");
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
