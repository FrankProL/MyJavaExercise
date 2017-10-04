package designPatterns.simplefactory.fenlijiemian;

public class Operation {
	public static int GetResult(int number1, int number2, String operate) {
		int result = 0;
		switch (operate) {
		case "+":
			result = number1 + number2;
			break;
		case "-":
			result = number1 - number2;
			break;
		case "*":
			result = number1 * number2;
			break;
		case "/":
			if (number2 == 0)
				System.out.println("������Ϊ��");
			else
				result = number1 / number2;
			break;

		default:
			System.out.println("��������");
			break;
		}
		return result;
	}
}
