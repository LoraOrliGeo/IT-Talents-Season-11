package module_three.test_three_exercise.test_three.models;

import module_three.test_three_exercise.test_three.models.breads.Bread;
import module_three.test_three_exercise.test_three.models.garnish.Garnish;
import module_three.test_three_exercise.test_three.models.meats.Meat;

import java.util.Random;

public class Client extends Thread {
    private Order order;

    public Client() {
        this.order = generateOrderWithRandomItems();
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("A client made an order");
                int milliseconds = StreetGrill.getInstance().makeOrder(this.order);
                Thread.sleep(milliseconds); // sleep for time that takes to make an order
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Order generateOrderWithRandomItems() {
        Bread.BreadType breadType = Bread.BreadType.values()[new Random().nextInt(Bread.BreadType.values().length)];
        Meat.MeatType meatType = Meat.MeatType.values()[new Random().nextInt(Meat.MeatType.values().length)];
        Garnish.GarnishType garnishType = Garnish.GarnishType.values()[new Random().nextInt(Garnish.GarnishType.values().length)];
        return new Order(breadType, meatType, garnishType);
    }
}
