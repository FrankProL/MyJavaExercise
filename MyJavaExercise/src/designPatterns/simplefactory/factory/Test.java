package designPatterns.simplefactory.factory;

public class Test {
	public static void main(String[] args) {
		Operation oper;
		new OperationFactory();
		oper=OperationFactory.createOperation("+");
		oper.setNumberA(1);
		oper.setNumberB(3);
		int result=oper.GetResult();
		System.out.println(result);
	}
}
