package module_three.design_patterns.factory;

public class Demo {
    public static void main(String[] args) {
        String s = "asd";
        s.intern();

        Pizzeria pizzeria = new Pizzeria(new PizzaFactory());
        pizzeria.orderPizza(PizzaType.CHEESE, 25);
        pizzeria.orderPizza(PizzaType.ITALIAN, 40);
    }
}
