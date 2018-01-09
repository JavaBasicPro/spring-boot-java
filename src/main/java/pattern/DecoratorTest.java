package pattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by jinpanpan on 2017/11/15.
 */
public class DecoratorTest {

    public static void main(String [] args){
        ConcreteComponent concreteComponent=new ConcreteComponent();
        ManDecoratorA manDecoratorA=new ManDecoratorA(concreteComponent);
        //ManDecoratorB manDecoratorB=new ManDecoratorB(concreteComponent);
        manDecoratorA.eat();
        //manDecoratorB.eat();
    }

}

/**装饰模式Decorator：又叫包装模式，角色有：
 * 1、抽象构件(Component)角色
 * 2、具体构件（ConcreteComponent）角色
 * 3、抽象装饰角色（Decorator）
 * 4、具体装饰角色（ConcreteDecoratorA）
 * 缺点：
 * 基于继承实现的，在编译期动态决定的，不利于在运行时动态的扩展
 * 特点:
 * 1、装饰者和被装饰者具有相同的超类
 * 2、一个对象可以有多个装饰者
 * 3、
 */
interface Component{
    public void eat();
}

//具体构件
class ConcreteComponent implements Component {

    @Override
    public void eat() {
        System.out.println("男人在吃");
    }
}

//装饰对象
abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void eat(){
        component.eat();
    }
}

//可以使用一个或者多个具体的装饰者去包装具体对象
class ManDecoratorA extends Decorator {

    public ManDecoratorA(Component component) {
        super(component);
    }

    public void eat(){
        super.eat();
        System.out.println("A开始吃");
      //  reEat();
    }

    //具体的装饰者可以添加一些新的方法
    public void reEat(){
        System.out.println("======= A在吃一顿");
    }
}

class ManDecoratorB extends Decorator {

    public ManDecoratorB(Component component) {
        super(component);
    }

    public void eat(){
        super.eat();
        System.out.println("B开始吃");
        reEat();
    }

    public void reEat(){
        System.out.println("======= B在吃一顿");
    }
}


/*
* 基于InputStream实现自己的装饰模式
* */
class LowerInputStream extends FileInputStream{

    public LowerInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    public int read() throws IOException {
        int c=super.read();
        return 0;
}

}
