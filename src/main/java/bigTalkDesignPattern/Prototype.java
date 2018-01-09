package bigTalkDesignPattern;

import java.util.Date;

/*
 * 原型模式
 * */
public class Prototype {

	public static void main(String[] args) throws CloneNotSupportedException {
        //最原始的方法 实现复制三份简历:创建三个对象
		Resume re1=new Resume();
		re1.setPersonInfo("zhang san", 30);
		
		Resume re2=new Resume();
		re2.setPersonInfo("zhang san", 30);
		
		Resume re3=new Resume();
		re3.setPersonInfo("zhang san", 30);
		re1.display();
		re2.display();
		re3.display();
		System.out.println("============");
		//这个是传的引用，把re1的引用地址传给了re4,
		Resume re4=re1;
		Resume re5=re1;
		re4.display();
		re5.display();
		
		/*通过实现clone方法实现浅复制：clone方法会复制一个新的对象并把元对象的非静态字段一同复制都新的对象,
		 * 如果原对象字段类型是基本类型 则：逐位复制各个字段，若是引用类型则只复制引用不复制引用的对象(数据不复制)，因此原始对象和副本指向同一个对象，这中情况需要通过
		 * “深复制来解决”
		 * 深复制：把引用对象的变量指向复制过来的新对象 而不是只复制对象的引用
		*/
		PrototypeT c=new PrototypeT("test",10); 
		PrototypeT c1=(PrototypeT) c.clone();
		System.out.println("c:"+c.getClass()+"         c1:"+c1.getClass().getName()
				+"        id="+c1.getId());
		c1.setId("KKK");
		System.out.println("id="+c1.getId()+";c.id="+c.getId());
	}

}

/*
 * 背景：同样的简历复制三份
 */
class Resume {
	private String name;
	private int age;

	public void setPersonInfo(String name, int age) {
		this.name=name;
		this.age=age;
		System.out.println("name="+name+"age="+age);
	}

	public void display() {
		
		System.out.println("name="+this.name+"age="+this.age);
	}
}

/*原型模式：从一个对象在创建另一个可定制的对象，而且不需要知道任何创建的细节，通过实现clone接口实现，
 * 1、原型类：原始的要克隆的类
 * 2、克隆之后的类：
 * 优点：动态的复制现有对象，提高了创建对象的效率，而且隐藏了对象创建的细节
*/
//浅复制
class PrototypeT implements Cloneable{
	
	private String id;
	private int age;
	public PrototypeT(String id,int age) {
		this.id = id;
		this.age=age;
	}
	
	/*浅复制为什么要重写clone()方法呢？
	 * 在运行时刻，Object中的clone()识别出你要复制的是哪一个对象，然后为此对象分配空间，并进行对象的复制，将原始对象的内容一一复制到新对象的存储空间中。 
	 * */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object  obj=super.clone();
      	return obj;
	}
    public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setId(String id) {
		this.id = id;
	}
}
/*实现简历的深复制,引用类型要实现Object的clone方法来完成深复制
 * */
class Resume1 implements Cloneable{
	private String name;
	private int age;
	WorkExperience workExperience;
	public Resume1(String name, int age,WorkExperience workExperience) {
		super();
		this.name = name;
		this.age = age;
		this.workExperience=workExperience;
	}
	@Override
	public String toString() {
		return "Resume1 [name=" + name + ", age=" + age + ", workExperience=" + workExperience + "]";
	}
}
class WorkExperience implements Cloneable{
	
	private Date time;
	private String experience;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public Object clone(){
		Object object=null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	@Override
	public String toString() {
		return "WorkExperience [time=" + time + ", experience=" + experience + "]";
	}
}

