package demo.thread;

import java.util.Scanner;

public class MultiCalc {
	private long startTime = 0L;			//��ʼʱ��
	private long endTime = 0L;				//����ʱ��
	private long totalResult = 0L;			//�ܺ�
	private Boolean[] isCompleted=null;		//�����߳��Ƿ����������ʶ
	
	//�жϸ����߳��Ƿ��������
	private boolean isSuccessed(){
		for(int i=0;i<isCompleted.length;i++){
			if(!isCompleted[i]){
				return false;
			}
		}
		return true;
	}
	
	//�����߳̽��м���
	private void startUP() {
		int threadnum;								//�����߳���
		long numbers = 1000000L;					//1��numbers���
		System.out.println("������Ҫ�������߳���");
		Scanner scanner = new Scanner(System.in);
		threadnum = scanner.nextInt();
		isCompleted=new Boolean[threadnum];
		
		System.out.println("��ʼ��ʱ");
		startTime = System.currentTimeMillis();		//��ȡ��ʼ����ʱ��ʱ�������
		for (int i = 1; i <= threadnum; i++) {
			isCompleted[i-1]=false;					//��ʼ�����飬���������ʾ��ʼ��
			//�����̣߳����ﲻ�Ǵ���һ������Ȼ�󴴽��ܶ��̣߳����Ǵ����ܶ����Ȼ��ÿ�����󴴽��߳�
			//�������߳�֮�乲������������������Ա��ͬһ������̼߳䣬�ڴ��й����Ա������
			//���ﴴ���˺ܶ����ע��������ͬ��ʱֻ�ܶ�ͬһ�������������������ټ���this��ָ��ǰ����
			Thread t = new Thread(new CalcThread(i, numbers, threadnum));
			t.start();
		}
		synchronized (MultiCalc.this) {			//ͬ��ʱ��ʹ��MultCalc.this������������������this
			try {								//MultiCalc���ǵ�ǰ����
				
					MultiCalc.this.wait();		//����ֱ�����߳������껽��
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("��ʱ�������ܺ�ʱΪ" + (endTime - startTime) + "ms");
		System.out.println("������Ϊ: " + totalResult);
	}


	class CalcThread implements Runnable {
		private long start;			//�̶߳�Ӧ�����ݶο�ʼ
		private long end;			//�̶߳�Ӧ�����ݶ�ĩβ
		private long result;		//���̼߳�����
		private int threadIndex;	//�̱߳�ţ�1->threadnum��
		
		//���ָ��߳�Ҫ�������ݶεĿ�ʼ�ͽ���λ��
		public CalcThread(int threadIndex, long numbers, int threadnum) {
			this.threadIndex=threadIndex;
			long step = numbers / threadnum;
			start = (threadIndex - 1) * step + 1;
			if (threadIndex == threadnum) {
				end = numbers;
			} else {
				end = threadIndex * step;
			}
			// System.out.println(Thread.currentThread().getName() + "---->"
			// + start + "~" + end);
		}

		@Override
		public void run() {
			for (long i = start; i <= end; i++) {		//���̶߳Զ�Ӧ�ֶν����ۼӼ���
				result += i;
			}
			// System.out.println(result);

			synchronized (MultiCalc.this) {
				totalResult += result;					//�����̵߳ļ������ۼ�
				isCompleted[this.threadIndex-1]=true;	//�����������Ӧ��ʶ��true
				if(isSuccessed())						//���ȫ�������꣬�������߳�
					MultiCalc.this.notify();
			}
			//System.out.println(totalResult);
		}

	}
	
	public static void main(String[] args) {
		(new MultiCalc()).startUP();

	}
}
