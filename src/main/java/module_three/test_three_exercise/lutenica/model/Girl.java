package module_three.test_three_exercise.lutenica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Girl extends Person implements Runnable {

    public Girl(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                Hut.getInstance().addVegetablesToBasket(generateRandomVegetables());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Vegetable> generateRandomVegetables() {
        List<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(Vegetable.PEPPER);
        vegetables.add(Vegetable.EGGPLANT);
        vegetables.add(Vegetable.TOMATO);
        vegetables.add(Vegetable.PEPPER);
        vegetables.add(Vegetable.EGGPLANT);
        vegetables.add(Vegetable.TOMATO);
//        int count = new Random().nextInt(4) + 3;
//        for (int i = 0; i < count; i++) {
//            switch (new Random().nextInt(3)) {
//                case 0:
//                    vegetables.add(Vegetable.PEPPER);
//                    break;
//                case 1:
//                    vegetables.add(Vegetable.TOMATO);
//                    break;
//                case 2:
//                    vegetables.add(Vegetable.EGGPLANT);
//                    break;
//            }
//        }
        return vegetables;
    }
}
