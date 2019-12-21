package module_three.test_three_exercise.test_three.models.meats;

import module_three.test_three_exercise.test_three.models.StreetGrill;

import java.util.Random;

public class GrillMan extends Thread {
    @Override
    public void run() {
        while (true) {
            StreetGrill.getInstance().addMeatToPot(generateMeatWithRandomType());
        }
    }

    private Meat generateMeatWithRandomType() {
        return new Meat(Meat.MeatType.values()[new Random().nextInt(Meat.MeatType.values().length)]);
    }
}
