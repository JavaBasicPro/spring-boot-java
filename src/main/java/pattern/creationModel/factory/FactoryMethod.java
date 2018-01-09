package pattern.creationModel.factory;

/**
 * Created by jinpanpan on 2017/11/24.
 */
/*
* 工厂方法模式:定义了一个创建对象的接口，由其子类决定要实例化的类是哪一个，工厂方法模式把类的实例化推迟到了子类中
* 1、工厂接口：也可以使用
* 2、工厂实现
* 3、产品接口
* 4、产品实现
*符合 开闭原则
* 参考：https://www.cnblogs.com/zhangchenliang/p/3700820.html
* */
public class FactoryMethod {

    public static void main(String [] args){
        Driver d = new BenzDriver();
        Car c = d.createCar("benz");
        c.setName("benz");
       c.driver();
    }
}

//抽象产品角色
abstract class Car{
    private String name;

    public abstract void driver();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//具体产品
class Benz extends Car {

    @Override
    public void driver() {
        System.out.println("=====benz======");
    }
}

class Bmw extends Car {

    @Override
    public void driver() {
        System.out.println("=====bmw======");
    }
}

//抽象工厂
abstract class Driver{
    public abstract Car createCar(String car);
}

//具体的每个工厂
class BenzDriver extends Driver {

    @Override
    public Car createCar(String car) {
        return new Benz();
    }
}

class BmwDriver extends Driver {

    @Override
    public Car createCar(String car) {
        return new Bmw();
    }
}