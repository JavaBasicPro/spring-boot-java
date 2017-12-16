package bigTalkDesignPattern;

/*
 * 策略模式
 * */
public class Strategy {

	public static void main(String[] args) {
		// 简单工厂
		// CashSpuer cashSpuer=CashFactory.createCash("打八折");

		Context context;
		context = new Context(new ConcreteStrategyA());
		context.contextInterface();

		context = new Context(new ConcreteStrategyB());
		context.contextInterface();

		System.out.println("======================");
		CashContext cashContext = null;
		String type = "8折";
		switch (type) {
		case "8折":
			cashContext = new CashContext(new CashNormal());

		case "5折":
			cashContext = new CashContext(new CashRebate());

			break;
		default:
			cashContext = new CashContext(new CashReturn());
			break;
		}
		cashContext.getCash();
		
		System.out.println("======================");
		
		CashContext c=new CashContext("8折");
		c.getCash();
		
	}

}

/*
 * 背景:商场收银系统计算 价格
 * 
 */
class Sale {

	public void bClick() {
		double totalPrice = new Double(11) * 2;
		System.out.println("单价：" + 11 + "数量" + 2 + "总价：" + totalPrice);
	}
}

/*
 * 搞活动，增加打折
 */
class Sale1 {

	public double getType(String type, double price, int qual) {
		double totalPrice = 0.0;
		switch (type) {
		case "打八折":
			totalPrice = price * qual * 0.8;
			return totalPrice;

		case "打五折":
			totalPrice = price * qual * 0.5;
			return totalPrice;

		default:
			return price * qual;
		}
	}
}

/**
 * 新需求：不仅要打折还有 慢300减50、满100减10，则使用上面的方法有需要做修改 面向对象编程并不是类越多越好的，类的划分是为了
 * 封装，但分类的基础是抽象，具有相同属性和功能的对象的抽象集合才是 类, 打一折和九折只是形式不同，抽象分析出来，所有的打折算法都是一样的，因此打折算法
 * 可以抽象为一个类 使用 简单工厂方法 抽象出具体的 算法类
 */
// 现金收费抽象类
abstract class CashSpuer {
	public abstract double accoutCash(double money); // 收取现金的抽象类、参数是原价，返回为当前价格
}

class CashNormal extends CashSpuer { // 正常收费，返回原价
	@Override
	public double accoutCash(double money) {
		// TODO Auto-generated method stub
		return money;
	}
}

class CashRebate extends CashSpuer { // 打八折的
	private double cashRebate;

	@Override
	public double accoutCash(double money) {
		this.cashRebate = money * 0.8;
		return cashRebate;
	}
}

class CashReturn extends CashSpuer { // 返利收费

	@Override
	public double accoutCash(double money) {
		// TODO Auto-generated method stub
		return 0;
	}
}

// 简单工厂类
class CashFactory {

	public static CashSpuer createCash(String type) {
		switch (type) {
		case "正常收费":
			return new CashNormal();
		case "打八折":
			return new CashRebate();
		case "满300件50":
			return new CashReturn();
		default:
			return null;
		}
	}
}

/**
 * 用简单工厂模式的缺点是: 在每次商场需要 修改促销打折方法时都需要修改 工厂方法类 * 封装变化点（如：不同的算法）是面向对象的一种重要思维
 * 策略模式：定义了算法家族，分别封装且可以相互替换，可以保证算法的修改不会影响到用算法的客户； 1、cotext
 * 上下文，维护一个对Strategy对象的引用 2、Strategy：策略类，定义所有支持的算法的公共接口
 * 3、StrategyA、StrategyB具体的抽象类，继承与Strategy
 */
// 抽象算法类
abstract class StrategyT {
	public abstract void calculateInterface();
}

class ConcreteStrategyA extends StrategyT {

	@Override
	public void calculateInterface() {
		System.out.println("算法a的具体实现");
	}
}

// 实现具体算法的类
class ConcreteStrategyB extends StrategyT {
	@Override
	public void calculateInterface() {
		System.out.println("算法B的具体实现");
	}
}

// 存放上下文，用ConcreteStrategyB来配置，唯一对策略抽象类的引用
class Context {
	StrategyT strategyT;

	public Context(StrategyT strategyT) {
		super();
		this.strategyT = strategyT;
	}

	public void contextInterface() {
		strategyT.calculateInterface();
	}
}

/*
 * 用策略模式代替上面的 CashSpuer 实现商城促销活动算法
 * 
 * 上面的 CashSpuer 相当于抽象策略，具体的CashNormal等相当于算法，所有修改上面的模式只 需要加一个 上下文存抽象策略的引用
 * 并修改客户端的调用方法即可
 */
class CashContext {
	private CashSpuer c;

	// 构造方法 传入具体的收费策略
	public CashContext(CashSpuer c) {
		super();
		this.c = c;
	}
	
	
	// 上述方法的缺点: 客户端要去判断调用那个方法，得想一个办法 吧这个判断移到业务逻辑端？ 使用 策略 模式 和工厂 模式 来解决该问题
	//通过这种方式后 客户端就只需要知道是哪一张算法即可，使算法和客户端分离，客户端不需要知道具体的算法，降低了耦合度
	public CashContext(String type) {
		super();
		switch (type) {
		case "8折":
			c = new CashNormal();
		case "5折":
			c = new CashRebate();
		default:
			c = new CashReturn();
		}
	}

	public void getCash() {

		c.accoutCash(11);
	}
}
/*策略模式总结：是一系列的算法簇，这些算法完成相同的工作（如：不同商品的打折算法），只是实现的方法不同，客户端可以通过上下文可以配置具体调用的算法，
 * 缺点是：需要客户端判断使用哪种算法，增加了客户端代码的复杂性，
 * 解决办法：结合使用工厂模式和策略模式
 * */

