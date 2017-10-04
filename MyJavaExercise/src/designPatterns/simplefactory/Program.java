package designPatterns.simplefactory;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		System.out.println("����������A");
		Scanner in = new Scanner(System.in);
		int A=in.nextInt();
		System.out.println("����������B");
		int B=in.nextInt();
		System.out.println("�����������");
		String C=in.next();
		int D = 0;
		switch (C) {
		case "+":
			D=A+B;
			break;
		case "-":
			D=A-B;
			break;
		case "*":
			D=A*B;
			break;
		case "/":
			D=A/B;
			break;

		default:
			System.out.println("���������");
			break;
		}
		System.out.println(A+C+B+"="+D);
	}
}
