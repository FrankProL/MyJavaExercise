package demo.thread;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final Scanner input = new Scanner(System.in);
		

		new Thread(new Runnable() {

			@Override
			public void run() {
				String str = null;
				while (!(str = input.next()).equals("quit")) {
					System.out.println(">>>>>" + str);
				}
			}
		}).start();
		
		long sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(sum);
	}
}
