package designPatterns.simplefactory.factory;

public class OperationAdd extends Operation{
	@Override
	public int GetResult() {
		int result;
		result=getNumberA()+getNumberB();
		
		return result;
	}
}
