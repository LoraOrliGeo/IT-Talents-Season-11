package module_three.design_patterns.factory;

public class PizzaFactory {

    public static Pizza createPizza(PizzaType type, int diameter) {
        Pizza pizza;

        switch (type) {
            case ITALIAN:
                pizza = new ItalianPizza(diameter);
                break;
            // cases for other pizza types
            default:
                pizza = new CheesePizza(diameter);
        }

        return pizza;
    }
}
