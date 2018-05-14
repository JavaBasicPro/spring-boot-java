package springjdbc;

/**
 * Created by jinpanpan on 2018/5/12.
 */
public interface UserService {

    void save();

    Person select();
}



class Person{

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}