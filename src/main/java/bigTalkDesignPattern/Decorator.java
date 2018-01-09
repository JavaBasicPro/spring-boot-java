package bigTalkDesignPattern;

/*装饰模式 Decorator
 * 已给女生搭配衣服为例,讲装饰模式的好处
 * 设计模式的 七大原则
 */
public class Decorator {

	public static void main(String[] args) {
		Person per = new Person("lily");

		System.out.println("lily  的第一种穿法：");

		per.wearShrits();

		per.wearSkirts();

		per.wearShoes();

		System.out.println("lily  的第二种穿法：");

		per.wearShrits();

		per.wearSuit();

		per.wearShoes();
		
		System.out.println("=================");

		Person person = new Person("lily");
		
		Finery shrits=new Shrits();
		Finery skirt=new Skirts();
		Finery shose=new Shoes();
		
		shrits.show();
		skirt.show();
		shose.show();
		person.show();
		

	}

}

class Person {

	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public void wearShrits() {
		System.out.print("衬衣");
	}

	public void wearShoes() {
		System.out.println("鞋子");
	}

	public void wearSkirts() {
		System.out.print("裙子");
	}

	public void wearSuit() {
		System.out.print("西裤");
	}
	
	public void show(){
		System.out.print(name+"穿的衣服");
	}
}


/*需求：现在要增加一种性的装扮衣服的方法了，该如何做呢？
 * 需要修改Person类，但是这就违背了 “开闭原则”
 * 第二种方法改造：
 * */
//服饰类
abstract class Finery{
	
	public abstract void show();
}

//各种衣服的子类
class Shrits extends Finery{
	
	@Override
	public void show() {
		System.out.print("衬衣");	
	}
}

class Shoes extends Finery{
	@Override
	public void show() {
		System.out.print("鞋子");	
	}
}

class Skirts extends Finery{
	@Override
	public void show() {
		System.out.print("裙子");
	}
}
class Suit extends Finery{
	@Override
	public void show() {
		System.out.print("西裤");
	}
}

/*上面的问题是：所有的调用顺序都由客户端完成，为什么不能再各个子类内部完成衣服的搭配，然后在出来见人呢？
 * 
 * 针对这个问题是否可以考虑使用“建造者模式”呢？，不能，因为建造者模式要求建造过程是稳定的，但是这里还有其他的搭配方式，不是一个固定的模式；
 * 那用什么方法比较好呢？ 可以考虑使用“装饰模式” 
 * 装饰模式：动态的给一个对象增加一些额外的职责，就增加功能来说，该模式比生成子类更灵活 * 
 * 功能：为已有类添加更过新 的功能，如：要为一个实现了核心功能的类 添加新的属性、新的方法和新的逻辑，这增加了代码的复制度而且这些新加入的功能只是为了
 * 实现在某些特殊情况下的子功能的，使用装饰模式就可以把新建的功能放在子类中的去实现，在让这个类包装原有的核心类，这样客户端就可以根据需求调用不同的、
 * 优点：把核心职责和装饰功能区分开，减少代码的复杂性，也符合开闭原则
 */


