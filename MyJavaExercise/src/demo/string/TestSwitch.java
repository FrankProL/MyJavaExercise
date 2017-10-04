package demo.string;

import java.util.Scanner;

public class TestSwitch {
	public static void main(String[] args) {
		
//		Scanner scanner=new Scanner(System.in);
//		String s=scanner.next();
//		switch (s) {
//		case "test":
//			System.out.println("this is test");
//			break;
//		case "hello":
//			System.out.println("hello");
//			break;
//
//		default:
//			System.out.println("no match");
//			break;
//		}
//		System.out.println(s.indexOf('a'));
		String s1="hello";
		String s2="hi";
		s1.concat(s2);
		System.out.println(s1);
		System.out.println(s1.concat(s2));
		s1=s1.concat(s2);
		System.out.println(s1);
		String s3="hi";
		System.out.println(s2==s3);
		System.out.println(s2.equals(s3));
		String s4=new String("hi");
		System.out.println(s2==s4);
		System.out.println(s2.equals(s4));
		
	}	
}
