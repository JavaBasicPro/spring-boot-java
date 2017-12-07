package pattern.proxy;

import java.util.Random;

/**
 * Created by jinpanpan on 2017/11/24.
 */
public class StaticProxy {

    public static void main(String [] args){
        Runner runner=new ProxyRunner(new RealRunner());
        runner.run();
    }

}

interface Runner {
    void run();
}

class RealRunner implements Runner {

    @Override
    public void run() {
        System.out.println("真正的跑步者");
    }
}


class ProxyRunner implements Runner {

    //代理类持有真实类的引用
    private Runner runner;

    public ProxyRunner(Runner runner) {
        this.runner = runner;
    }

    @Override
    public void run() {
        Random random=new Random();
        if(random.nextBoolean()){
            runner.run();
        }else {
            System.out.println("不满足条件则不跑");
        }
    }
}