package demo.thread;

import java.util.ArrayList;
/*
 * 下面这段代码是一段错误代码，也就是说在ArrayList这个集合里，不支持在同一线程中对ArrayList里面的数据
 * 同事进行读取和写入，即ArrayList集合是线程不安全的
 */
public class ThreadSafeDemo {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		for(String element:list){
			list.add(element+"aaa");		//对ArrayList类型list同时进行读写，ArrayList不是线程安全的，将出错
			System.out.println(element);
		}
	}
}
