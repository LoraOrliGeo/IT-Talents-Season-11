package module_three.test_three_exercise.lutenica.model;

public abstract class Person {
    private String name;
    private int age;

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
