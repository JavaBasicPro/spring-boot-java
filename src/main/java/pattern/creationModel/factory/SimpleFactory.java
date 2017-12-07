package pattern.creationModel.factory;

/**
 * Created by jinpanpan on 2017/11/24.
 */
/*
* 简单工厂模式：又称静态工厂模式
* 用于创建对象
* 有新的类时需要修改接口，违反了开闭原则
* */
public class SimpleFactory {

    public static void main(String [] arsg){

        CheesePizza cheesePizza = (CheesePizza) PizzaFactory.createPizza("cheese");
        cheesePizza.make();
    }
}

//简单工厂
class PizzaFactory{

    public static PizzaFactory  createPizza(String type){

        if(type.equals("cheese")){
            return new CheesePizza();
        }else {
            return new OtherPizza();
        }
    }

}
//具体产品1
class CheesePizza extends PizzaFactory{
    public void make(){
        System.out.println("制作蛋糕");
    }
}

class OtherPizza extends PizzaFactory{

    public void make(){
        System.out.println("烘培蛋糕");
    }

}