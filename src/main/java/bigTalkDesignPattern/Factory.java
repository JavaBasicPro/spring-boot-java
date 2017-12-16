package bigTalkDesignPattern;

/*工厂方法模式：简单工程模式、工厂方法模式、抽象工厂
 * 简单工厂与 工厂模式的比较:
 * 
 * 
 * */
public class Factory {
	
	public static void main(String [] args){
		//简单工厂模式
		Operation operation=LFengFactory.create("+");
		operation.wash();
		
		System.out.println("====================");
		
		//工厂模式
		IFactory ifFactory=new AddFactory();
		Add add=(Add) ifFactory.createFactory();
		add.add();
		
		IFactory ifF=new Substract();
		Sub sub= (Sub) ifF.createFactory();
		sub.sub();
	}

}

/*
 * 学习雷锋做好事：会有很多不同的人继承他去做好事
 * 
 */
class Operation {
	public void wash(){
		
	} 
}

class LFengFactory {
	public static Operation create(String type) {
		Operation operation = null;

		switch (type) {
		case "+":
			operation = new OperateAdd();
			break;
		case "-":
			operation = new OperateSubstract();
			break;
		default:
			break;
		}
		return operation;
	}
}

class OperateAdd extends Operation{
	public void add() {
		System.out.println("+");
	}

	@Override
	public void wash() {
		add();
	}
}

class OperateSubstract extends Operation{
	public void add() {
		System.out.println("-");
	}

	@Override
	public void wash() {
		add();
	}
}

//工厂类
interface IFactory{
	Operation createFactory();
}
class AddFactory implements IFactory{

	public Operation createFactory() {
		return new Add();
	}
}
class Add extends Operation{
	public void add(){
		System.out.println("加法");
	}
}
class  Sub extends Operation{
	public void sub(){
		System.out.println("减法");
	}	
}

class Substract implements IFactory{
	
	@Override
	public Operation createFactory() {
		// TODO Auto-generated method stub
		return new Sub();
	}
}
