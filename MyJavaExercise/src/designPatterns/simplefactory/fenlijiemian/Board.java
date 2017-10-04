package designPatterns.simplefactory.fenlijiemian;

import java.io.Console;
import java.util.Scanner;
/*
 * ���׼�����
 * ʵ�ֿͻ��˽�����������
 */
public class Board {
	public static void main(String[] args) {
		System.out.println("����������a");
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		System.out.println("����������b");
		int b=in.nextInt();
		System.out.println("�����������");
		String c=in.next();
		int result;
		result=Operation.GetResult(a, b, c);
		System.out.println(result);
	}
}
