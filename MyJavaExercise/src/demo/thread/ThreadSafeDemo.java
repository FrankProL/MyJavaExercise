package demo.thread;

import java.util.ArrayList;
/*
 * ������δ�����һ�δ�����룬Ҳ����˵��ArrayList����������֧����ͬһ�߳��ж�ArrayList���������
 * ͬ�½��ж�ȡ��д�룬��ArrayList�������̲߳���ȫ��
 */
public class ThreadSafeDemo {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		for(String element:list){
			list.add(element+"aaa");		//��ArrayList����listͬʱ���ж�д��ArrayList�����̰߳�ȫ�ģ�������
			System.out.println(element);
		}
	}
}
