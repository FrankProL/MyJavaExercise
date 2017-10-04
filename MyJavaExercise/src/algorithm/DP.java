package algorithm;

import java.util.ArrayList;

/**
 * 1,2,5
 * 11元
 * 如何输出所有的方式？
 * @author Frank
 *
 */
public class DP {
	public static void main(String[] args) {
		System.out.println(F(6));
	}
	
	public static int F(int n){
//		ArrayList<String> list=new ArrayList<String>();
//		if(n==1){
//			list.add("1");
//		}
//		if(n==2){
//			list.add("1");
//			list.add("1");
//		}
//		if(n==3){
//			list.addAll(F(2));
//			list.add("1");
//			list.add("-:-");
//			list.addAll(F(1));
//			list.add("2");
//		}
//		if(n==4){
//			list.addAll(F(3));
//			list.add("1");
//			list.add("-:-");
//			list.addAll(F(2));
//			list.add("2");
//		}
//		if(n==5){
//			list.addAll(F(4));
//			list.add("1");
//			list.add("-:-");
//			list.addAll(F(3));
//			list.add("2");
//			list.add("-:-");
//			list.add("5");
//		}
		int t=0;
		if (n==1){
			t=1;
		}
		if(n==2){
			t=1;
		}
		if(n>2&n<=5){
			t=F(n-1)+F(n-2);
		}
		if(n>5){
			t=F(n-1)+F(n-2)+F(n-5);
		}
		
		return t;
	}
}
