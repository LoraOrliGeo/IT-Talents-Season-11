package module_three.test_three_exercise.lutenica.model;

public class Boy extends Person implements Runnable {

    public Boy(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        while (true) {
            Vegetable vegetable = Hut.getInstance().takeVegetable();
            System.out.println("A boy took " + vegetable + " from basket and prepared it");
            Kitchen.getInstance().addVegetableToPan(vegetable);
            System.out.println("A boy added prepared " + vegetable + " to the kitchen");
        }
    }
}
