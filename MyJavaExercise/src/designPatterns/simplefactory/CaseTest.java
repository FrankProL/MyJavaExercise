package designPatterns.simplefactory;

public class CaseTest {
	public static void main(String[] args) {
		/*
		 * switch ���Ʊ��ʽ֧�ֵ�������
		 * byte��short��char��int��enum��Java 5����String(Java 7)
		 */
		char str = 'A';
		switch (str) {
		case 'A':
		    System.out.println('A');
		    break;
		case 'B':
		    System.out.println('B');
		    break;
		case 'C':
		    System.out.println('C');
		    break;
		default:
		    System.out.println(0);
		}
	}
}
