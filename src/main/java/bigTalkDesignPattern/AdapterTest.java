package bigTalkDesignPattern;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by jinpanpan on 2018/2/6.
 * 适配器模式：对象适配器 和 类适配器
 */
public class AdapterTest {

    public static void main(String [] args){

        /*类适配器*/
        Target_Person targetPerson=new Adapter_Person();

        targetPerson.sayEnglish();
        targetPerson.sayFrench();
        targetPerson.sayJapanese();

        /*对象适配器*/
        System.out.println("对象适配器");
        PersonA personA=new PersonA();
        Target_Person targetPerson1=new Adapter_Person2(personA);
        targetPerson1.sayEnglish();
        targetPerson1.sayJapanese();
        targetPerson1.sayFrench();

    }
}


/*类适配器：需要用到多重继承
* */
@Getter
@Setter
@ToString(exclude = {"id", "name", "age"})
@NoArgsConstructor
class PersonA {
    private String name;

    private int id;

    public void sayEnglish() {
        System.out.println("Person can say english1");
    }
}

interface Target_Person {
    void sayEnglish();

    void sayFrench();

    void sayJapanese();
}

class Adapter_Person extends PersonA implements Target_Person {

    /*@Override
    public void sayEnglish() {
        System.out.println("Person can say English!");
    }*/

    @Override
    public void sayFrench() {
        System.out.println("Person can say French!");
    }

    @Override
    public void sayJapanese() {
        System.out.println("Person can say Japanese!");
    }
}

/*对象适配器：使用组合
*
* */
class Adapter_Person2 implements Target_Person{

    private PersonA personA;

    public Adapter_Person2(PersonA personA) {
        this.personA = personA;
    }

    //实现目标接口中的 方法
    @Override
    public void sayEnglish() {
       personA.sayEnglish();
    }

    @Override
    public void sayFrench() {
        System.out.println("person can say French2!");
    }

    @Override
    public void sayJapanese() {
        System.out.println("person can say Japanese2!");
    }
}