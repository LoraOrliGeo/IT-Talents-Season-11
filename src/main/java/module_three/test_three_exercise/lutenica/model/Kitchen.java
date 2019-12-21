package module_three.test_three_exercise.lutenica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kitchen {

    private static Kitchen INSTANCE = new Kitchen();
    private List<Pan> pans;

    private Kitchen() {
        this.pans = new ArrayList<>();
        this.pans.add(new Pan(Vegetable.PEPPER));
        this.pans.add(new Pan(Vegetable.TOMATO));
        this.pans.add(new Pan(Vegetable.EGGPLANT));
    }

    public void addVegetableToPan(Vegetable vegetable) {
        Pan pan = getProperPan(vegetable);
        pan.addVegetableToPan(vegetable);
    }

    private Pan getProperPan(Vegetable vegetable) {
        for (Pan pan : this.pans) {
            if (pan.getVegetableType() == vegetable) {
                return pan;
            }
        }
        return null;
    }

    public static Kitchen getInstance() {
        return INSTANCE;
    }

    public int takePreparedVegetables() {
        for (Pan pan : this.pans) {
            pan.takeVegetables();
        }

        return new Random().nextInt(10) + 3;
    }
}
