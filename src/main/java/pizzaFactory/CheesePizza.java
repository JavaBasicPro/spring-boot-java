package pizzaFactory;

/**
 * Created by jinpanpan on 2018/2/2.
 */
public class CheesePizza extends  Pizza {

    PizzaIngredFactory ingredFactory;

    public CheesePizza(PizzaIngredFactory ingredFactory) {
        this.ingredFactory = ingredFactory;
    }

    @Override
    void prepare() {
        System.out.println();

        System.out.println("prepare"+getName());
        dough=ingredFactory.createDough();
        sauce=ingredFactory.createSauce();
        cheese=ingredFactory.createCheese();
    }
}
