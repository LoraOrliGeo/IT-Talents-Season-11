package module_three.test_three_exercise.lutenica.model;

import module_three.test_three_exercise.lutenica.Pissaro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hut {
    private static Hut INSTANCE = new Hut();
    private List<Basket> baskets;

    private Hut() {
        this.baskets = new ArrayList<>();
        baskets.add(new Basket(Vegetable.TOMATO));
        baskets.add(new Basket(Vegetable.PEPPER));
        baskets.add(new Basket(Vegetable.EGGPLANT));
    }

    public static Hut getInstance() {
        return INSTANCE;
    }

    public void addVegetablesToBasket(List<Vegetable> vegetables) {
        for (Vegetable vegetable : vegetables) {
            Basket b = getProperBasket(vegetable);
            if (b != null) {
                b.addVegetable(vegetable);
                System.out.println("Girl added " + vegetable + " to basket with " + b.getType());
            }
        }
    }

    private Basket getProperBasket(Vegetable vegetable) {
        for (Basket b : this.baskets) {
            if (b.getType() == vegetable) {
                return b;
            }
        }
        return null;
    }

    public Vegetable takeVegetable() {
        try {
            Collections.shuffle(this.baskets);
            Vegetable vegetable = this.baskets.get(0).takeVegetable();
            Thread.sleep(vegetable.getPreparationTime() * 1000);
            return vegetable;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
