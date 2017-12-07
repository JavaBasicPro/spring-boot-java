package pattern;

/**
 * Created by jinpanpan on 2017/11/24.
 */
/*
*装饰模式和代理模式的主要区别：
* 装饰模式：可以动态的给一个对象增加额外的职责；通过抽象类实现接口，在定义多个具体的装饰者 extends 该抽象类
* 代理模式：控制对真实角色的访问，使客户对真实角色透明
*
* 具体使用：AOP使用了代理模式
* 装饰模式的使用：  OutputStream out = new DataOutputStream（ new FileOutputStream（ "test.txt"）)
*
* */
public class ProxyAndDecorator {

    public static void main(String [] args){
        ConCreRunnerImpl conCreRunner=new ConCreRunnerImpl();
        DeRunnerA deRunnerA=new DeRunnerA(conCreRunner);
        deRunnerA.run();
    }

}

//装饰模式
interface DeRunnner{
    void run();
}

//具体的模式
class ConCreRunnerImpl implements DeRunnner{

    @Override
    public void run() {
        System.out.println("我是具体的被装饰的构件，开跑");
    }
}
/*装饰抽象类
   1、装饰抽象类可以扩展DeRunnner的功能，但DeRunnner不需要知道该"抽象类"的存在
   2、具体的装饰者 给DeRunnner添加功能的目的
*/
abstract class  DeRunner implements DeRunnner{

   private DeRunnner  deRunnner;

    public DeRunner(DeRunnner deRunnner) {
        this.deRunnner = deRunnner;
    }

    public void eat(){
        deRunnner.run();
    }

    public abstract void see() ;
}

class DeRunnerA extends DeRunner{

    public DeRunnerA(DeRunnner deRunnner) {
        super(deRunnner);
    }

    @Override
    public void see() {

    }

    @Override
    public void run() {
        super.eat();
    }
}


class DeRunnerB extends DeRunner{

    public DeRunnerB(DeRunnner deRunnner) {
        super(deRunnner);
    }

    @Override
    public void see() {

    }

    @Override
    public void run() {
        System.out.println("具体的装饰者，开始跑");
    }
}