package module_three.threads.making_rakia;

public class Cauldron {
    private FruitType fruit;
    private int kilograms;
    private static final int CAPACITY = 10;
    private int number;

    public Cauldron(int number) {
        this.number = number;
    }

    public FruitType getFruit() {
        return this.fruit;
    }

    public boolean isEmpty() {
        return this.kilograms == 0;
    }

    public boolean isFull() {
        return this.kilograms == CAPACITY;
    }

    public void fill(FruitType fruit) {
        this.fruit = fruit;
        this.kilograms++;
        System.out.println(String.format("%s added 1 kg of %s in cauldron %d",
                Thread.currentThread().getName(), fruit, this.number));
    }

    public void empty() {
        this.kilograms = 0;
        System.out.println(String.format("%s made rakia of %s from cauldron %d",
                Thread.currentThread().getName(), fruit, this.number));
        this.fruit = null;
    }
}
