package pattern.creationModel.factory;

/**
 * Created by jinpanpan on 2017/11/27.
 */
/*
* 抽象工厂模式：给客户端提供一个接口，可以创建多个产品族中的对象
*1、抽象工厂角色
* 2、具体工厂角色
* 3、抽象产品角色
* 4、具体产品角色
* */
public class AbstractFactory {


}

//抽象产品（）
abstract  class  BenzCar{

    private String name;

    public abstract void driver();

    public BenzCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class BenzSportCar extends BenzCar {

    public BenzSportCar(String name) {
        super(name);
    }

    @Override
    public void driver() {
        System.out.println("=====benzSportCar====");
    }
}

class BmwBusinessCar extends BenzCar {

    public BmwBusinessCar(String name) {
        super(name);
    }

    @Override
    public void driver() {
        System.out.println("=====BmwBusinessCar====");
    }
}
