package module_three.design_patterns.factory;

public class Pizzeria {
    private PizzaFactory factory;

    public Pizzeria(PizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(PizzaType type, int diameter) {
        Pizza pizza = factory.createPizza(type, diameter);
        pizza.prepare();
        pizza.bake();
        pizza.box();
        return pizza;
    }

    // the factory could be a static method here: private static Pizza createPizza()
}
