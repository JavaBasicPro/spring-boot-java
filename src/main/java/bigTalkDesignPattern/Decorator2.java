package bigTalkDesignPattern;

/**
 * Created by jinpanpan on 2018/2/1.
 */
public class Decorator2 {

    public static void main(String[] args) {

        Beverage beverage=new Espresso();  //定一杯咖啡

        System.out.println("beverage:"+beverage.des+"价格："+beverage.cost());


        Beverage beverage1=new HouseBlend();
        beverage1=new Mocha(beverage1);

        beverage1=new MochaBigSize(beverage1);

        System.out.println("Mocha:"+beverage1.des+"价格："+beverage1.cost()+"size:"+beverage1.getSize());

        //beverage1==new DarkRoast(beverage1);


    }
}

// 抽象咖啡类
abstract class Beverage{

    String des="unknown beverage";

    String size="大杯";

    public String getDes() {
        return des;
    }

    public String getSize() {
        return size;
    }

    protected  abstract  double cost();
}

//给咖啡添加的 调料 抽象类;;要确保该类能够替代 Beverage
abstract class CondimentDecorator extends  Beverage{

    @Override
    public abstract String getDes();
}

//咖啡大小 的抽象类
abstract class SizeDecorator extends Beverage{

    @Override
    public abstract String getSize();
}

class MochaBigSize extends SizeDecorator{

    Beverage beverage;

    public MochaBigSize(Beverage beverage){

        beverage=beverage;
    }

    @Override
    public String getSize() {
        return "大杯";
    }

    @Override
    protected double cost() {

        System.out.println("cost:"+beverage.cost());

        return beverage.cost()+ 20;
    }
}

//具体的咖啡 类,,只有咖啡的价格，不算所有的调料
class Espresso extends Beverage{

    public Espresso(){
        des="Espresso";
    }

    @Override
    protected double cost() {
        return 1.99;
    }
}

class HouseBlend extends Beverage{

    public HouseBlend(){
        des="HouseBlend";
    }
    @Override
    protected double cost() {
        return 0.89;
    }
}

//具体的调料类，具体的调料装饰类
class Mocha extends  CondimentDecorator{

    Beverage beverage;

    public Mocha(Beverage beverag){
       beverage=beverag;
    }

    @Override
    protected double cost() {
        return  beverage.cost()+12.9;  //具体的咖啡加上调料价格；；如果父类是具体类而不是抽抽象类，那么这里只能是重写
    }

    @Override
    public String getDes() {
        return beverage.getDes()+"Mocha";
    }
}

//另一种具体的调料类，具体的调料装饰类
class DarkRoast extends CondimentDecorator {

    Beverage beverage;

    public DarkRoast(Beverage beverag){
        beverage=beverag;
    }

    @Override
    protected double cost() {
        return beverage.cost()+20.8;
    }

    @Override
    public String getDes() {
        return beverage.getDes()+"a";
    }
}