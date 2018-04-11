/**
 * Created by jinpanpan on 2018/4/9.
 */
public class C {

    private T tt;

    public void f(){

        System.out.println("方法f");

        a();   //类C的方法

        T t=new T();   //由方法f创建的对象

        t.b();

        tt.b(); //C的实力持有的对象
    }

    public void a(){

        System.out.println("方法a");
    }
}
class T{

    public void b(){
        System.out.println("方法b");
    }
}