package module_three.threads.making_rakia;

public abstract class Person extends Thread {
    private int age;
    private FruitType fruit;
    protected static Distillery distillery = new Distillery();

    protected Person(String name, int age, FruitType fruit) {
        super(name);
        this.age = age;
        this.fruit = fruit;
    }

    public FruitType getFruit() {
        return fruit;
    }
}
