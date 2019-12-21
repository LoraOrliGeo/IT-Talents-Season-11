package module_three.test_three_exercise.test_three.models.breads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BreadBasket {

    private static final int NUMBER_OF_BREADS = 30;
    private BlockingQueue<Bread> breads;
    private Bread.BreadType type;

    public BreadBasket(Bread.BreadType type) {
        this.type = type;
        this.breads = new ArrayBlockingQueue<>(NUMBER_OF_BREADS);
    }

    public void addBread(Bread bread) {
        try {
            this.breads.put(bread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Bread.BreadType getBreadType() {
        return this.type;
    }

    public Bread takeBread() {
        try {
            this.breads.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
