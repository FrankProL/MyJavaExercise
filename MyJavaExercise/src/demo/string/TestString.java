package demo.string;

import java.util.ArrayList;

public class TestString {

	public static void main(String[] args) {
	
		//String 、new String //字符串、字符串常量
		String str1="java";
		String str2="java";
//		String str1 = new String("java");
//		String str2 = new String("java");
//		System.out.println(str1 == str2);
//		System.out.println(str1.equals(str2));


//		String s=str1+str2;
//		System.out.println(s=="javajava");
//		System.out.println(s.equals("javajava"));
		
//		String s="java"+"java";
//		System.out.println(s=="javajava");
//		System.out.println(s.equals("javajava"));
		
//		String str3="blog";
//		String s="java"+str3;
//		System.out.println(s=="javablog");
		
		////////////////////////////////////
		//Integer
		for (int i=0;i<10;i++){
			Integer t=new Integer(i);
			System.out.println(t);
		}
		
		Integer i1=10;
	    Integer i2=10;
	    Integer i3=new Integer(10);
	    Integer i4=128;
	    Integer i5=128;
	    System.out.println(i1==i2);//true
	    System.out.println(i1==i3);//false
	    System.out.println(i4==i5);//false
		
	    ////////////////////////////////////////////////
		//ArrayList集合
		int sum=0;
		ArrayList list =new ArrayList();
		for (int i=1;i<=10;i++){
			list.add(i);
		}
		for (int i=0;i<10;i++){
			int num=(Integer)list.get(i);
			sum=sum+num;
		}
		System.out.println(sum);
		
	}

}
