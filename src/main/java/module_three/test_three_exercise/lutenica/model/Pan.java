package module_three.test_three_exercise.lutenica.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Pan {
    public static final int NUMBER_OF_PREPARED_VEGETABLES = 30;
    private Vegetable vegetableType;
    private BlockingQueue<Vegetable> vegetables;

    public Pan(Vegetable vegetableType) {
        this.vegetableType = vegetableType;
        this.vegetables = new ArrayBlockingQueue<>(NUMBER_OF_PREPARED_VEGETABLES);
    }

    public void addVegetableToPan(Vegetable v) {
        try {
            if (v == vegetableType) {
                this.vegetables.put(v);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Vegetable getVegetableType() {
        return vegetableType;
    }

    public void takeVegetables() {
        for (int i = 0; i < 5; i++) {
            try {
                this.vegetables.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
