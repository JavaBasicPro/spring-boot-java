package pattern.composite;

/**
 * Created by jinpanpan on 2018/1/9.
 *抽象类 规定统一的操作行为
 */
public abstract class Component {

    private String name;

    public abstract void add(Component c);

    public abstract void remove(Component c);

    public abstract void eachChild();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
