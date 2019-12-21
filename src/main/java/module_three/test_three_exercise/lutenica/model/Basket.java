package module_three.test_three_exercise.lutenica.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Basket {
    private static final int MAX_QUANTITY_VEGIES_IN_BASKET = 40;
    private Vegetable vegetableType;
    private BlockingQueue<Vegetable> vegetables;

    public Basket(Vegetable vegetableType) {
        this.vegetableType = vegetableType;
        this.vegetables = new ArrayBlockingQueue<>(MAX_QUANTITY_VEGIES_IN_BASKET);
    }

    public void addVegetable(Vegetable vegetable) {
        if (vegetable == this.vegetableType) {
            try {
                this.vegetables.put(vegetable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Vegetable getType() {
        return this.vegetableType;
    }

    public Vegetable takeVegetable() {
        try {
            return this.vegetables.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
