package module_three.test_three_exercise.test_three.models.meats;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MeatPot {

    private static final int MAX_NUMBER_OF_MEATS = 20;
    private Meat.MeatType meatType;
    private BlockingQueue<Meat> meats;

    public MeatPot(Meat.MeatType meatType) {
        this.meatType = meatType;
        this.meats = new ArrayBlockingQueue<>(MAX_NUMBER_OF_MEATS);
    }

    public Meat.MeatType getMeatType() {
        return meatType;
    }

    public void addMeat(Meat meat) {
        try {
            this.meats.put(meat);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Meat takeMeat() {
        try {
            return this.meats.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
