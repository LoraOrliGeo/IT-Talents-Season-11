package test_two_exercise.sweetshop.clients;

import test_two_exercise.sweetshop.cakes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class Client extends Person {
    private String address;
    private double spentMoney;

    public Client(String name, String number, String address) {
        super(name, number);
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void spendMoney(double money) {
        this.spentMoney += money;
    }

    public double getSpentMoney() {
        return this.spentMoney;
    }

    public abstract void makeOrder();

    protected abstract int getRandomNumberOfCakes();

    List<Cake> chooseCakes() {
        List<Cake> cakes = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < getRandomNumberOfCakes(); i++) {
            Cake cake = null;
            CakeStyle cakeStyle = CakeStyle.values()[r.nextInt(CakeStyle.values().length)];
            String type = cakeStyle.getTypes().get(r.nextInt(cakeStyle.getTypes().size()));

            for (Set<Cake> cakesInCatalogue : sweetshop.getCatalogue().values()) {
                for (Cake c : cakesInCatalogue) {
                    if (c.getStyle().equals(cakeStyle) && c.getType().equals(type)) {
                        cake = c;
                    }
                }
            }

            cakes.add(cake);
        }
        return cakes;
    }

    public abstract double getPercentTip();

    @Override
    public String toString() {
        return String.format("%s - spent money: %.2f", this.getName(), this.getSpentMoney());
    }
}
