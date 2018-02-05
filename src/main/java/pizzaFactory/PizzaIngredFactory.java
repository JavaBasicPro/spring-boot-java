package pizzaFactory;

/**
 * Created by jinpanpan on 2018/2/2.
 */
public interface PizzaIngredFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClams();
}
