package effectivejava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by jinpanpan on 2017/11/26.
 */
public class Method {

    public static void main(String[] args) {

        firstTest();

        int age = 12;
        String name = "测试";
        Person person = new Person(age, name);
        System.out.println("===>" + person.getName() + ";" + person.getAge());

        age = 100;
        name = "aaa";
        System.out.println("===>" + person.getName() + ";" + person.getAge());

        //第三
        secondTest();


        //方法重写


    }

    private static void firstTest() {
        Date start = new Date();
        Date end = new Date();
        PeriodT period = new PeriodT(start, end);
        System.out.println("===>" + period.getEnd());

        end.setYear(78);

        System.out.println("===>" + period.getEnd());

    }

    private static void secondTest() {
        Date start = new Date();
        Date end = new Date();
        PeriodT period = new PeriodT(start, end);
        period.getEnd().setYear(20);
        System.out.println("===>" + period.getEnd());
        System.out.println("===>" + period.getStart());
    }

}

class PeriodT {
    private Date start;
    private Date end;

    //1、直接使用客户端传递的属性
    public PeriodT(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    //2、进行对象的拷贝
    /*public Period(Date start, Date end) {
        this.start =new Date(start.getTime());
        this.end = new Date(end.getTime());

        //针对拷贝后的参数进行校验，确保必要参数可用
        if(start.compareTo(end)>0){
            throw new IllegalArgumentException();
        }
    }*/

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}

class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
* 慎用重载
* Collection<?> 运行时类型是不同的，但调用那个重载方法是在编译时决定的
* 该方法的编译时类型为 Collection<?>，所以在每次迭代中都会调用 classify(Collection<?> s)
* 方法重写 调用那个方法 是在运行时根据被调用方法所在对象的运行时类型决定的
*
* 子类覆盖父类的方法，且用子类的对象调用该方法，那么将会执行子类中的方法，和子类的编译时类型无关。
* */
class CollectionTest {

    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> s) {
        return "List";
    }

    public static String classify(Collection<?> s) {
        return " Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<String>(),
                new HashMap<String, String>().values()

        };
        for (Collection<?> c : collections) {
            System.out.println("输出为：" + classify(c));
        }
    }
}

/*
* 方法重写
* */
class Wine{
    public void name(){
        System.out.println("wine") ;
    }
}

class SparkWine extends Wine {

    public void name(){
        System.out.println("SparkWine");
    }

    /*public static void main(String[] args) {
        SparkWine sparkWine=new SparkWine();
        sparkWine.name();
    }*/
}

class Champague extends Wine {

    public void name(){
        System.out.println("Champague wine");
    }

    public static void main(String[] args) {
        Wine[] wines={ new Wine(),new SparkWine(),new Champague()};
        for(Wine wine:wines){
            wine.name();
        }
    }
}


/*希望输出的是：
[-3, -2, -1] [-3, -2, -1]
实际输出：
[-3, -2, -1] [-2, 0, 2]
实际list去除了非整数和奇数值
原因是：在java有了 泛型和自动装箱后，更加需要慎用重载；
List<E>有两个重载方法remove(Object o)和remove(int index)，E不是基本类型,所以需要把从i自动封箱为Integer
 *结论：当能确保传递相同的参数，所有重载方法的返回值都相同时，才可用重载，如果做不到这一点，就请慎用重载，否则方法可能返回你想不到的值。
 * */
class SetList{
    public static void main(String [] args){
        Set<Integer> set=new TreeSet<>();
        List<Integer> list=new ArrayList<Integer>();

        for(int i=-3;i<3;i++){
            set.add(i);
            list.add(i);
        }

        for(int i=0; i<3;i++){
            set.remove(i);
            //list.remove(i);
            //解决自动封箱产生的问题
            list.remove((Integer)i);
        }

        System.out.println("==================");
        System.out.println(set+" "+list);
    }
}