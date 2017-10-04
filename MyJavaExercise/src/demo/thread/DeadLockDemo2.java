package demo.thread;

import java.util.Arrays;

public class DeadLockDemo2 {
	public static void main(String[] args) {
		class MyThread extends Thread {
			private char[] source;
			private char[] dest;

			public MyThread(char[] source, char[] dest) {
				super();
				this.source = source;
				this.dest = dest;
			}

			@Override
			public void run() {
				System.out.println(this.getName() + "�߳̿�ʼ");
				synchronized (source) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(Thread.currentThread().getName());

					synchronized (dest) {
						System.out.println("enter2");
						dest = Arrays.copyOf(source, source.length);
					}
				}
				System.out.println(this.getName() + "�߳̽���");
			}
		}

		char[] c1 = { 'a', 'b', 'c', 'd' };
		char[] c2 = { '1', '2', '3', '4' };
		
		MyThread t1=new MyThread(c1, c2);
		t1.start();
		
		MyThread t2=new MyThread(c2, c1);
		t2.start();
	}
}
