package demo.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
/*
 * ����ջ
 */
public class BlockingDequeDemo {
	public static void main(String[] args) throws InterruptedException {
		final BlockingDeque bDeque=new LinkedBlockingDeque(20);
		
		for(int i=0;i<30;i++){
			//��ָ��Ԫ����ӵ�ջ�У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ��
			bDeque.putFirst(i);
			System.out.println("������ջ���������Ԫ�أ�"+i);
		}
		System.out.println("�������е��˼�������������");
	}
}
