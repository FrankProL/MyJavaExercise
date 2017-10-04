package demo.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
/*
 * 阻塞栈
 */
public class BlockingDequeDemo {
	public static void main(String[] args) throws InterruptedException {
		final BlockingDeque bDeque=new LinkedBlockingDeque(20);
		
		for(int i=0;i<30;i++){
			//将指定元素添加到栈中，如果没有可用空间，将一直等待（如果有必要）
			bDeque.putFirst(i);
			System.out.println("向阻塞栈中添加了新元素："+i);
		}
		System.out.println("程序运行到此即将结束。。。");
	}
}
