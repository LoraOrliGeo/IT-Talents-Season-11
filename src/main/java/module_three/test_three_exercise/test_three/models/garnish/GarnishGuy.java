package module_three.test_three_exercise.test_three.models.garnish;

import module_three.test_three_exercise.test_three.models.StreetGrill;

import java.util.Random;

public class GarnishGuy extends Thread {
    @Override
    public void run() {
//        while (true) {
            try {
                StreetGrill.getInstance().addGarnishToGarnishBow(generateGarnishWithRandomType());
            } catch (NotEnoughSpaceException e) {
                System.out.println(e.getMessage());
            }
//        }
    }

    private Garnish generateGarnishWithRandomType() {
        return new Garnish(Garnish.GarnishType.values()[new Random().nextInt(Garnish.GarnishType.values().length)]);
    }
}
