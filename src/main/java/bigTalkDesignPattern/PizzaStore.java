package bigTalkDesignPattern;


/**
 * Created by jinpanpan on 2018/2/2.
 *
 *简单工厂模式
 */
public class PizzaStore {

    SimplePizzaFactory simplePizzaFactory;

    public  Pizza  orderPizza(){

      return  simplePizzaFactory.createPizzaStore("");
    }
}

class SimplePizzaFactory{

    public Pizza createPizzaStore(String type){
       if (type==""){
           return new CheesePizza();
       }else {
           return new ClamPizza();
       }
    }
}


abstract class PizzaStore2{

    public Pizza orderPizza(String type){
        return  createPizza("22");
    }

    //各个地方 处理订单的方式都相同，只是【创建】的披萨 口味略有不同
    abstract Pizza createPizza(String type);
}

abstract class Pizza{

   abstract void prepare();

   abstract void bake();

   abstract void cut();

   abstract void box();
}

class CheesePizza extends  Pizza{

    @Override
    void prepare() {

    }

    @Override
    void bake() {

    }

    @Override
    void cut() {

    }

    @Override
    void box() {

    }
}
class ClamPizza extends  Pizza{

    @Override
    void prepare() {

    }

    @Override
    void bake() {

    }

    @Override
    void cut() {

    }

    @Override
    void box() {

    }
}

class NYStylePizza2 extends PizzaStore2{

    @Override
    Pizza createPizza(String type) {
        return null;
    }
}