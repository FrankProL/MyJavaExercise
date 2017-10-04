package demo.thread;

import java.util.Scanner;

public class MultiCalc {
	private long startTime = 0L;			//开始时间
	private long endTime = 0L;				//结束时间
	private long totalResult = 0L;			//总和
	private Boolean[] isCompleted=null;		//各个线程是否运算结束标识
	
	//判断各个线程是否运算结束
	private boolean isSuccessed(){
		for(int i=0;i<isCompleted.length;i++){
			if(!isCompleted[i]){
				return false;
			}
		}
		return true;
	}
	
	//启动线程进行计算
	private void startUP() {
		int threadnum;								//启动线程数
		long numbers = 1000000L;					//1到numbers求和
		System.out.println("请输入要开启的线程数");
		Scanner scanner = new Scanner(System.in);
		threadnum = scanner.nextInt();
		isCompleted=new Boolean[threadnum];
		
		System.out.println("开始计时");
		startTime = System.currentTimeMillis();		//获取开始计算时的时间毫秒数
		for (int i = 1; i <= threadnum; i++) {
			isCompleted[i-1]=false;					//初始化数组，运算结束标示初始化
			//创建线程，这里不是创建一个对象然后创建很多线程，而是创建很多对象然后每个对象创建线程
			//这样的线程之间共享代码区，而不共享成员（同一对象的线程间，内存中共享成员变量）
			//这里创建了很多对象，注意后面加锁同步时只能对同一对象上锁解锁，不能再简单用this（指当前对象）
			Thread t = new Thread(new CalcThread(i, numbers, threadnum));
			t.start();
		}
		synchronized (MultiCalc.this) {			//同步时都使用MultCalc.this对象的锁，这里可以用this
			try {								//MultiCalc就是当前对象
				
					MultiCalc.this.wait();		//挂起，直到子线程运算完唤醒
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("计时结束，总耗时为" + (endTime - startTime) + "ms");
		System.out.println("计算结果为: " + totalResult);
	}


	class CalcThread implements Runnable {
		private long start;			//线程对应的数据段开始
		private long end;			//线程对应的数据段末尾
		private long result;		//该线程计算结果
		private int threadIndex;	//线程编号（1->threadnum）
		
		//划分各线程要计算数据段的开始和结束位置
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
			for (long i = start; i <= end; i++) {		//各线程对对应分段进行累加计算
				result += i;
			}
			// System.out.println(result);

			synchronized (MultiCalc.this) {
				totalResult += result;					//将个线程的计算结果累加
				isCompleted[this.threadIndex-1]=true;	//运算结束，对应标识置true
				if(isSuccessed())						//如果全部运算完，则唤醒主线程
					MultiCalc.this.notify();
			}
			//System.out.println(totalResult);
		}

	}
	
	public static void main(String[] args) {
		(new MultiCalc()).startUP();

	}
}
