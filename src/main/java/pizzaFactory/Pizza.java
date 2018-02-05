package pizzaFactory;

/**
 * Created by jinpanpan on 2018/2/2.
 */
public abstract class Pizza {

    private String name;

    Dough dough;

    Sauce sauce;

    Cheese cheese;

    Veggies[] veggies;

    Pepperoni pepperoni;

    Clams clams;

    abstract void prepare();

    void bake(){
        System.out.println("bake");
    }

    void cut(){
        System.out.println("cut");
    }

    void box(){
        System.out.println("box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}