package demo.thread;

public class WaitDemo1 {
	public static void main(String[] args) {
		ThreadB b= new ThreadB();
		
		b.start();
		//�߳�Aӵ��b�����ϵ���
		//�߳�Ϊ�˵���wait()��notify()���������̱߳������Ǹ������ӵ����
		synchronized (b) {
			try {
				System.out.println("�ȴ�b��ɼ���");
				b.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			System.out.println("b���������ܺ��ǣ�"+b.total);
		}
	}
}
/*
 * ����1��100�ĺ�
 */
class ThreadB extends Thread{
	int total;
	@Override
	public void run() {
		synchronized (this) {
			for(int i=0;i<101;i++){
				total+=i;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			//������ɺ󣬻����ڴ˶���������ϵȴ��ĵ����̣߳��������߳�A������
			notify();
		}
	}
}