package pattern.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jinpanpan on 2017/11/24.
 */
//动态代理模式
public class DynamicProxy {

    public static void main(String [] args){
        DyRealRunner dyRealRunner=new DyRealRunner();
        DyRunner dyRunner= (DyRunner) Proxy.newProxyInstance(DyRunner.class.getClassLoader(),new Class[]{DyRunner.class},new ProxyHandler(dyRealRunner));
        dyRealRunner.run();

    }

}

interface  DyRunner {
    void run();
}

class DyRealRunner implements DyRunner{

    @Override
    public void run() {
         System.out.println("真是的人在跑");
    }
}

//代理角色
class ProxyHandler implements InvocationHandler{

    private DyRunner dyRunner;

    public ProxyHandler(DyRunner dyRunner) {
        this.dyRunner = dyRunner;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //在调用具体目标前可以做一些处理
        // 调转具体的目标对象
        return  method.invoke(dyRunner,args);

        //调用之后可以做一些事情
    }
}