package test_two_exercise.sweetshop.clients;

import test_two_exercise.sweetshop.Sweetshop;

public abstract class Person {
    private String name;
    private String number;
    public static Sweetshop sweetshop;

    public Person(String name, String number) {
        setName(name);
        setNumber(number);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name != null)
            this.name = name;
    }

    private void setNumber(String number) {
        this.number = number;
    }
}
