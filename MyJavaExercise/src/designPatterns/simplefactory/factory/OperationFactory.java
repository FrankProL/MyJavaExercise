package designPatterns.simplefactory.factory;

public class OperationFactory {
	public static Operation createOperation(String operate){
		Operation oper=null;
		switch (operate) {
		case "+":
			oper=new OperationAdd();
			break;

		default:
			break;
		}
		return oper;
	}
	
	
}
