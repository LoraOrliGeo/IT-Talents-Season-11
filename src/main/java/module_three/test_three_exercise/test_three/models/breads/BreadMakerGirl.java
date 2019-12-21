package module_three.test_three_exercise.test_three.models.breads;

import module_three.test_three_exercise.test_three.models.StreetGrill;

import java.util.Random;

public class BreadMakerGirl extends Thread {
    @Override
    public void run() {
        while (true) {
            StreetGrill.getInstance().addBreadToBasket(getBreadWithRandomType());
        }
    }

    private Bread getBreadWithRandomType() {
        int idx = new Random().nextInt(Bread.BreadType.values().length);
        return new Bread(Bread.BreadType.values()[idx]);
    }
}
