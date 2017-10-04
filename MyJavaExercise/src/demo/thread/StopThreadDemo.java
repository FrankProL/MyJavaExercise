package demo.thread;
/*
 * �߳���ֹʾ��---�Ƽ�ʹ�ã�ʹ��whileѭ��������״̬��ʶ��
 */
public class StopThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		CanStopRunner runner=new CanStopRunner();
		Thread t=new Thread(runner);
		t.start();
		Thread.sleep(1000);
		runner.stop();			//t.stop();�Ѳ��Ƽ�ʹ��
	}
}

class CanStopRunner implements Runnable{
	private boolean stop=false;	//����״̬��ʶ���˳���ʶ
	@Override
	public void run() {
		while (!stop) {			//���ϵ����У�ֱ��״̬��ʶ�ı�
			System.out.println("���������С�����");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//�ı�״̬��ǣ�ʹ�߳���ֹ
	public void stop(){
		stop=true;
	}
}