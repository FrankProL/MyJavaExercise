package demo.thread;
/*
 * java�̣߳�����Э��--������������(�ֿ�)ģ��
 */
public class ProducerConsumerDemo {
	public static void main(String[] args) {
		Godown godown=new Godown(30);
		Consumer c1=new Consumer(50, godown);
		Consumer c2=new Consumer(20, godown);
		Consumer c3=new Consumer(30, godown);
		
		Producer p1=new Producer(10, godown);
		Producer p2=new Producer(10, godown);
		Producer p3=new Producer(10, godown);
		Producer p4=new Producer(10, godown);
		Producer p5=new Producer(10, godown);
		Producer p6=new Producer(10, godown);
		Producer p7=new Producer(80, godown);
		
		c1.start();
		c2.start();
		c3.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
	}
}

/*
 * �ֿ�
 */
class Godown{
	public static final int max_size=100;	//�������
	public int curnum;						//��ǰ�����
	
	public Godown() {
		// TODO Auto-generated constructor stub
	}

	public Godown(int curnum) {
		super();
		this.curnum = curnum;
	}

	/*
	 * ����ָ�������Ĳ�Ʒ
	 */
	public synchronized void produce(int neednum){
		//�����Ƿ���Ҫ����
		while(neednum+curnum>max_size){
			System.out.println("Ҫ�����Ĳ�Ʒ����"+neednum+"����ʣ������"+(max_size-curnum)+",��ʱ�޷�����");
			try {
				//��ǰ�������̵߳ȴ�
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//���������������������������򵥵�ֱ�Ӹ��ĵ�ǰ�����
		curnum+=neednum;
		System.out.println("�Ѿ�������"+neednum+"����Ʒ�����ڲִ���Ϊ"+curnum);
		//�����ڴ˶���������ϵ������߳�
		notifyAll();
	}
	/*
	 * ����ָ�������Ĳ�Ʒ
	 */
	public synchronized void consume(int neednum){
		//�����Ƿ������
		while (curnum<neednum){
			try {
				//��ǰ�������̵߳ȴ�
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//��������������������ѣ�����򵥵�ֱ�Ӹ��ĵ�ǰ�����
		curnum-=neednum;
		System.out.println("�Ѿ�������"+neednum+"����Ʒ�����ڲִ���Ϊ"+curnum);
		//�����ڴ˶���������ϵ������߳� 
		notify();
	}
}

/*
 * ������
 */
class Producer extends Thread{	//���������������õ��ǲֿ���ⷽ��
	private int neednum;		//������Ʒ������
	private Godown godown;		//�ֿ�
	public Producer(int neednum, Godown godown) {
		super();
		this.neednum = neednum;
		this.godown = godown;
	}
	@Override
	public void run() {
		godown.produce(neednum);
	}
	
}

/*
 * ������
 */
class Consumer extends Thread{
	private int neednum;		//������Ʒ������
	private Godown godown;		//�ֿ�
	
	public Consumer(int neednum, Godown godown) {	//���������ѣ����õ��ǲֿ����ķ���
		super();
		this.neednum = neednum;
		this.godown = godown;
	}
	
	@Override
	public void run() {
		//����ָ����Ʒ������
		godown.consume(neednum);
	}
	
}